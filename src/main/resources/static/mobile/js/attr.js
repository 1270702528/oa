$(function(){
	$('#attr-wu-datagrid').datagrid({ loadFilter: pagerFilter }).datagrid({
		url:'../../../attachment/list?id='+id,	
		method:'GET',	
		singleSelect:true,
		scrollbarSize:0,       
		pagination:true,
		fitColumns:true,
		fit:true,
		title:"附件",
			columns:[[
				{ field:'name',title:'附件名',width:80,
					styler: function(value,row,index){
						if (row.remark){
							return 'background-color:#ffee00;color:red;';
						}
					}},
				{ field:'userName',title:'上传者',width:30	},
				{ field:'oper',title:'操作',width:30,
					formatter:function(value,row,index){	
						var link;
						var url=row.imageUrl;
						if(url!=""){
							url=url.substring(url.length-3);
							if(url!='pdf'){
								link='<a target="_blank" href="'+row.imageUrl+'">查看</a> &nbsp;&nbsp;&nbsp;';	
							}else{
							    link='<a target="_blank" href="../../../process/mobile/viewPdf/'+row.id+'">查看</a> &nbsp;&nbsp;&nbsp;';	
							}
						}else{
							link='未上传';
						}
						
						return link;	
					}}
				
			]]
	
	});

})


