package com.yucaijr.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import com.yucaijr.form.CommentForm;
import com.yucaijr.form.TaskForm;
import com.yucaijr.model.ProjectInfo;


public interface ProcessService {

	/**
	 * 是否部署
	 * @return
	 */
	public boolean isDelopy();
	/**
	 * 部署
	 */
	public void delopy();
	
	/**
	 * 启动流程
	 */
	public void startProcess(int  id);
	
	/**
	 * 创建用户
	 * @param username
	 */
	public void addUser(String username);
	
	/**
	 * 创建组
	 * @param groupName
	 */
	public void addGroup(String groupName);
	
	/**
	 * 创建关系
	 * @param username
	 * @param groupName
	 */
	public void createMembership(String username,String  ... groupName);
	
	/**
	 * 删除关系
	 * @param username
	 * @param groupName
	 */
	public void deleteMembership(String username,String  ... groupName);
	
	
	/**
	 * 查询任务
	 * @param roles
	 * @return
	 */
	public List<Task> findTaskList(List<String> roles);
	
	/**
	 * 根据任务id查找项目信息
	 * @param taskId
	 * @return
	 */
	public ProjectInfo findProjectInfoByTaskId(String taskId);
	
	
	/**
	 * 查找流程图
	 * @param deploymentId
	 * @param imageName
	 * @return
	 */
	public InputStream findImageInputStream(String deploymentId,String imageName);
	
	/**
	 * 根据任务id查找备注
	 * @param taskId
	 * @return
	 */
	public List<Comment> findCommentByTaskId(String taskId);
	
	/**
	 * 根据项目id查找备注
	 * @param id
	 * @return
	 */
	public List<Comment> findCommentByProjectId(int id);
	
	/**
	 * 根据任务id查找流程定义对象
	 * @param taskId
	 * @return
	 */
	public ProcessDefinition findProcessDefinitionByTaskId(String taskId);
	
	/**
	 * 根据任务id查找处于流程的坐标
	 * @param taskId
	 * @return
	 */
	public Map<String, Object> findCoordingByTask(String taskId);
	
	/**
	 * 办理任务
	 * @param type
	 * @param taskId
	 * @param comment
	 * @param username
	 */
	public void complete(int type,String taskId,String comment,String username);
	
	/**
	 * comment转化
	 * @param comments
	 * @return
	 */
	public List<CommentForm> converter(List<Comment> comments);
	
	/**
	 * task转化
	 * @param comments
	 * @return
	 */
	public List<TaskForm> converterTasks(List<Task> tasks);
	
	/**
	 * project转换
	 * @param projectInfos
	 */
	public void converterProject(List<ProjectInfo> projectInfos);
	
	/**
	 * 根据项目id查找任务
	 * @param projectId
	 * @return
	 */
	public Task findTasKByProjectId(int projectId);
	
	
}
