package com.yucaijr.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yucaijr.constant.ProcessConst;
import com.yucaijr.dao.ProjectInfoDao;
import com.yucaijr.form.CommentForm;
import com.yucaijr.form.TaskForm;
import com.yucaijr.model.ProjectInfo;
import com.yucaijr.service.ProcessService;
import com.yucaijr.util.DateTimeTool;



@Service(value="processService")
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private ProjectInfoDao ProjectInfoDao;
	

	@Override
	public void delopy() {
		repositoryService.createDeployment()
		.addClasspathResource("process/bidAudit.bpmn")
		.addClasspathResource("process/bidAudit.png")
		.deploy();
		
	}

	@Override
	public void startProcess(int id ) {
		//启动流程
		runtimeService.startProcessInstanceByKey(ProcessConst.PROCESS_DEFINCE_ID, ProcessConst.BUSINESS_KEY+","+id);
		
		//修改状态
		ProjectInfoDao.updateStatus(id, 1);
	}

	@Override
	public void addUser(String username) {
		identityService.saveUser(new UserEntity(username));
		
	}

	@Override
	public void addGroup(String groupName) {
		identityService.saveGroup(new GroupEntity(groupName));	
	}

	@Override
	public void createMembership(String username, String... groupNames) {
		for( String groupName:groupNames) {
			identityService.createMembership(username, groupName);
		}
	}

	@Override
	public void deleteMembership(String username, String... groupNames) {
		for( String groupName:groupNames) {
			identityService.deleteMembership(username, groupName);
		}
	}

	@Override
	public boolean isDelopy(){
		long count=repositoryService.createDeploymentQuery()
									.processDefinitionKey(ProcessConst.PROCESS_DEFINCE_ID)
									.count();
		return count!=0;
	}

	@Override
	public List<Task> findTaskList(List<String> roles) {
		List<Task> tasks=taskService.createTaskQuery()
									.taskCandidateGroupIn(roles)
									.list();
		return tasks;
	}

	@Override
	public ProjectInfo findProjectInfoByTaskId(String taskId) {
		
		Task task = taskService.createTaskQuery()
							   .taskId(taskId)
						       .singleResult();

		String processInstanceId = task.getProcessInstanceId();
		
		String taskName=task.getName();

		ProcessInstance pi = runtimeService.createProcessInstanceQuery()
						.processInstanceId(processInstanceId)
						.singleResult();

		String buniness_key = pi.getBusinessKey();

		String id = "";
		if(buniness_key!=null &&buniness_key.contains(",")){
			id = buniness_key.split(",")[1];
			ProjectInfo projectInfo= ProjectInfoDao.getById(Integer.parseInt(id));
			
			if(taskName.equals(ProcessConst.PROJECT_START) ||
			   taskName.equals(ProcessConst.RISK_HEADER_AUDIT) || taskName.equals(ProcessConst.PROJECT_REVIEW) ||
			   taskName.equals(ProcessConst.PROJECT_REVIEW2) ||  taskName.equals(ProcessConst.PROJECT_REVIEW2)) {
				projectInfo.setOperType(1);
			}else if(taskName.equals(ProcessConst.IS_FULL_BID)) {
				projectInfo.setOperType(2);
			}else if(taskName.equals(ProcessConst.MARKET_AUDIT)) {
				projectInfo.setOperType(1);
				projectInfo.setCheckType(1);
			}else if(taskName.equals(ProcessConst.RISK_COMMISSIONER_AUDIT)) {
				projectInfo.setCheckType(2);
			}else if(taskName.equals(ProcessConst.ONLINE_NOTICE)) {
				projectInfo.setCheckType(3);
			}else if(taskName.equals(ProcessConst.SEND_BID)) {
				projectInfo.setCheckType(4);
			}else if(taskName.equals(ProcessConst.NOTICE_PROJECT_MANAGER)) {
				projectInfo.setCheckType(5);
			}
			
			return projectInfo;
		}
		return null;
	}

	@Override
	public InputStream findImageInputStream(String deploymentId, String imageName) {
		return repositoryService.getResourceAsStream(deploymentId, imageName);
	}

	@Override
	public List<Comment> findCommentByTaskId(String taskId) {
		List<Comment> list = new ArrayList<Comment>();
	
		Task task = taskService.createTaskQuery()
				.taskId(taskId)//使用任务ID查询
				.singleResult();
		
		//获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();

		list = taskService.getProcessInstanceComments(processInstanceId);
		return list;
	}

	@Override
	public List<Comment> findCommentByProjectId(int id) {

		ProjectInfo projectInfo = ProjectInfoDao.getById(id);
		
		String objId = ProcessConst.BUSINESS_KEY+","+projectInfo.getId();
		
		/**1:使用历史的流程实例查询，返回历史的流程实例对象，获取流程实例ID */
		HistoricProcessInstance hpi = historyService.createHistoricProcessInstanceQuery()//对应历史的流程实例表
						.processInstanceBusinessKey(objId)//使用BusinessKey字段查询
						.singleResult();
		//流程实例ID
		String processInstanceId = hpi.getId();
		
	
		List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);
		return list;
	}

	@Override
	public ProcessDefinition findProcessDefinitionByTaskId(String taskId) {
				//使用任务ID，查询任务对象
				Task task = taskService.createTaskQuery()//
							.taskId(taskId)//使用任务ID查询
							.singleResult();
				//获取流程定义ID
				String processDefinitionId = task.getProcessDefinitionId();
				//查询流程定义的对象
				ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()//创建流程定义查询对象，对应表act_re_procdef 
							.processDefinitionId(processDefinitionId)//使用流程定义ID查询
							.singleResult();
				return pd;
			
	}

	@Override
	public Map<String, Object> findCoordingByTask(String taskId) {
		//存放坐标
		Map<String, Object> map = new HashMap<String,Object>();
		//使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery()
					.taskId(taskId)//使用任务ID查询
					.singleResult();
		//获取流程定义的ID
		String processDefinitionId = task.getProcessDefinitionId();
		//获取流程定义的实体对象（对应.bpmn文件中的数据）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processDefinitionId);
		//流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		//使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//创建流程实例查询
					.processInstanceId(processInstanceId)//使用流程实例ID查询
					.singleResult();
		//获取当前活动的ID
		String activityId = pi.getActivityId();
		//获取当前活动对象
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);//活动ID
		//获取坐标
		map.put("x", activityImpl.getX());
		map.put("y", activityImpl.getY());
		map.put("width", activityImpl.getWidth());
		map.put("height", activityImpl.getHeight());
		return map;
	}

	@Override
	public void complete(int type,String taskId,String comment,String username) {
		//查找任务
		Task task = taskService.createTaskQuery()
				.taskId(taskId)
				.singleResult();

		//添加备注
		String processInstanceId = task.getProcessInstanceId();
		Authentication.setAuthenticatedUserId(username);
		taskService.addComment(taskId, processInstanceId, comment);
		
		//判断办理任务事项,下面的都是需要设置变量的
		String taskName=task.getName();
		//变量
		Map<String, Object> variables=new HashMap<>();
		
		ProjectInfo projectInfo=findProjectInfoByTaskId(taskId);
		
		switch (taskName) {
			case ProcessConst.PROJECT_START:
				if(type==0) {
					updateStatus(taskId,2);
				}
				projectInfo.setF64(username);
				projectInfo.setF65(username);
				projectInfo.setF48(username);
				projectInfo.setF77(DateTimeTool.getToday());
				variables.put(ProcessConst.PROJECT_AUDIT_VAR, type);
				break;
				
			case ProcessConst.MARKET_AUDIT:
				variables.put(ProcessConst.MARKET_AUDIT_VAR, type);
				projectInfo.setF66(comment +" " +username +" "+DateTimeTool.getToday());
				break;
				
			case ProcessConst.RISK_HEADER_AUDIT:
				variables.put(ProcessConst.RISK_AUDIT_VAR, type);
				projectInfo.setF68(comment);
				projectInfo.setF70(username);
				projectInfo.setF93(comment+" "+username+" "+DateTimeTool.getToday());
				break;	
	
			case ProcessConst.PROJECT_REVIEW:
				variables.put(ProcessConst.PROJECT_REVIEW_AUDIT_VAR, type);
				projectInfo.setF78(DateTimeTool.getToday());
				projectInfo.setF52(username);
				projectInfo.setF92(comment);
				projectInfo.setF95(comment+" "+username+" "+DateTimeTool.getToday());
				break;	
				
			case ProcessConst.PROJECT_REVIEW2:
				variables.put(ProcessConst.PROJECT_REVIEW_AUDIT_VAR2, type);
				projectInfo.setF78(DateTimeTool.getToday());
				projectInfo.setF52(username);
				projectInfo.setF95(comment+" "+username+" "+DateTimeTool.getToday());
				break;	
				
			case ProcessConst.IS_FULL_BID:
				if(type==0){
					updateStatus(taskId,4);
				}
				variables.put(ProcessConst.FULL_BID, type);
				projectInfo.setF74(comment);
				break;	
				
			case ProcessConst.LENDING:
				updateStatus(taskId,3);
				projectInfo.setF75(comment);
				projectInfo.setF76(username);
				projectInfo.setF80(DateTimeTool.getToday());
				break;
				
			case ProcessConst.RISK_COMMISSIONER_AUDIT:
				projectInfo.setF49(username);
				break;
				
			case ProcessConst.ONLINE_NOTICE:
				projectInfo.setF69(comment);
				projectInfo.setF94(comment+" "+username+" "+DateTimeTool.getToday());
				projectInfo.setF72(username);
				projectInfo.setF71(username);
				projectInfo.setF79(DateTimeTool.getToday());
				break;
				
			case ProcessConst.SEND_BID:
				projectInfo.setF73(username);
				break;
				
		}
		ProjectInfoDao.update(projectInfo);
		taskService.complete(taskId, variables);
	}


	
	private void updateStatus(String taskId,int status) {
		ProjectInfo projectInfo=findProjectInfoByTaskId(taskId);
		if(projectInfo!=null) {
			ProjectInfoDao.updateStatus(projectInfo.getId(), status);	
		}
	}

	@Override
	public List<CommentForm> converter(List<Comment> comments) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<CommentForm> commentForms=new ArrayList<>();
		for (Comment comment : comments) {
			HistoricTaskInstance hpi=historyService.createHistoricTaskInstanceQuery().taskId(comment.getTaskId()).singleResult();
			CommentForm commentForm=new CommentForm(comment.getUserId(), sdf.format(comment.getTime()), comment.getFullMessage(),hpi.getName());
			commentForms.add(commentForm);
		}
		return commentForms;
	}

	@Override
	public List<TaskForm> converterTasks(List<Task> tasks) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<TaskForm> taskForms=new ArrayList<>();
		for(Task t:tasks) {
			TaskForm taskForm=new TaskForm();
			t.getProcessInstanceId();
			
			
			String businesskey=runtimeService.createProcessInstanceQuery()
					 .processInstanceId(t.getProcessInstanceId())
					 .singleResult()
					 .getBusinessKey();
			if(businesskey!=null &&businesskey.length()>0) {
				String ids=businesskey.split(",")[1];
				ProjectInfo projectInfo= ProjectInfoDao.getById(Integer.parseInt(ids));
				taskForm.setTitle(projectInfo.getTitle());
			}
			taskForm.setTaskId(t.getId());
			taskForm.setTaskName(t.getName());
			taskForm.setCreateTime(sdf.format(t.getCreateTime()));
			taskForms.add(taskForm);
		}
		return taskForms;
	}

	@Override
	public void converterProject(List<ProjectInfo> projectInfos) {
		for(ProjectInfo projectInfo:projectInfos) {
			Task task=taskService.createTaskQuery()
					.processInstanceBusinessKey(ProcessConst.BUSINESS_KEY+","+projectInfo.getId())
					.singleResult();
			if(task==null){
				if(projectInfo.getStatus()==0) {
					projectInfo.setTaskName("未开始");
				}else {
					projectInfo.setTaskName("已完结");
				}	
			}else{
				projectInfo.setTaskName(task.getName());
			}
		}
		
	}

	@Override
	public Task findTasKByProjectId(int projectId) {
		Task task=taskService.createTaskQuery()
				.processInstanceBusinessKey(ProcessConst.BUSINESS_KEY+","+projectId)
				.singleResult();
		return task;
	}

	
	
}
