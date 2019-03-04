$(function(){
	$('#doc-wu-datagrid').datagrid({
		url:'../../../project/docs?id='+id,	
		method:'GET',	
		singleSelect:true,    
		scrollbarSize:0,       
		pagination:true,
		fitColumns:true,
		fit:true,
		columns:[[
			{ field:'name',title:'文件名',width:100},
			{ field:'status',title:'状态',width:100,
				formatter:function(value){
					if(value==1){
						return "已生成";
					}else{
						return "未生成";
					}
				
			}},
			{ field:'oper',title:'操作',width:100,
				formatter:function(value,row,index){
					var link="";
					link+='<a href="../../../process/mobile/viewInfo/'+id+'/'+index+'">查看</a> &nbsp;&nbsp;&nbsp;';
					return link;	
				}
			}

		]]
	});	

})




