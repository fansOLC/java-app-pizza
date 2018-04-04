$(function(){
	//页面初始化查询数据
	page();
	//$("[data-toggle='tooltip']").tooltip();
})
var pageIndex;	


//点击查询
function searchData(){
	page();
}

//分页查询
function page(curr){
	var pageSize=2;
	$.ajax({
		url:"suspect_searchData",
		dataType:"json",
		data:{
			pageNo: curr || 1,
			pageSize: pageSize,
			name:$('input[name="name"]').val(),
			age:$('input[name="age"]').val(),
			rysj:$('input[name="rysj"]').val(),
			jg:$('input[name="jg"]').val()
		},
		type:"POST",
		success:function(data){
			searchAll(data,pageSize,curr);
		},
		error:function(){
			alert("加载数据失败");
		}
	})
}




//查询成功
function searchAll(data,pageSize,curr){
	pageIndex=data.page.pageNo;
	datas=data.content;
	pageDetail(data,pageSize,curr);//分页函数 1、引入page.js、page.css 2、定义pageSize 3、提交给后台数据PAGE:curr||1
	$('#searchData>tbody').empty();
	$.each(datas,function(i){
		$('#searchData>tbody').append(
			/*"<tr>"+
				"<td data-toggle='tooltip' data-container='body'>"+(i+1)+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+(datas[i].name==null?"":datas[i].name)+"'>"+(datas[i].name==null?"":datas[i].name)+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+(datas[i].sfzId==null?"":datas[i].sfzId)+"'>"+(datas[i].sfzId==null?"":datas[i].sfzId)+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+(datas[i].age==null?"":datas[i].age)+"'>"+(datas[i].age==null?"":datas[i].age)+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+(datas[i].rysj_t==null?"":datas[i].rysj_t)+"'>"+(datas[i].rysj_t==null?"":datas[i].rysj_t)+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+(datas[i].xb==null?"":datas[i].xb)+"'>"+(datas[i].xb==null?"":datas[i].xb)+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+(datas[i].ryyy==null?"":datas[i].ryyy)+"'>"+(datas[i].ryyy==null?"":datas[i].ryyy)+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+(datas[i].xq==null?"":datas[i].xq)+"'>"+(datas[i].xq==null?"":datas[i].xq)+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+(datas[i].jg==null?"":datas[i].jg)+"'>"+(datas[i].jg==null?"":datas[i].jg)+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+(datas[i].file_name==null?"":datas[i].file_name)+"'>"+(datas[i].file_name==null?"":datas[i].file_name)+"</td>"+
				"<td>" +
					"<div style='text-align:center'>" +
						"<i onclick='showEdit("+datas[i].susId+")' data-toggle='tooltip' data-container='body' title='编辑' style='color:#5bc0de;font-size:18px;cursor:pointer' class='fa fa-edit'></i>&nbsp;&nbsp;" +
						"<i onclick='showDetail("+datas[i].susId+")' data-toggle='tooltip' data-container='body' title='详情' style='color:#51C1C2;font-size:18px;cursor:pointer' class='fa fa-reorder'></i>&nbsp;&nbsp;" +
						"<i onclick='deleteData("+datas[i].susId+")' data-toggle='tooltip' data-container='body' title='删除' style='color:#F1817F;font-size:18px;cursor:pointer' class='fa fa-trash-o'></i>" +
					"</div>" +
				"</td>"+
			"</tr>"*/
				`<tr>
				<td data-toggle='tooltip'>${i+1}</td>
				<td data-toggle='tooltip'>${datas[i].name==null?"":datas[i].name}</td>
				<td data-toggle='tooltip'>${datas[i].sfzId==null?"":datas[i].sfzId}</td>
				<td data-toggle='tooltip'>${datas[i].age==null?"":datas[i].age}</td>
				<td data-toggle='tooltip'>${datas[i].rysj_t==null?"":datas[i].rysj_t}</td>
				<td data-toggle='tooltip'>${datas[i].xb==null?"":datas[i].xb}</td>
				<td data-toggle='tooltip'>${datas[i].ryyy==null?"":datas[i].ryyy}</td>
				<td data-toggle='tooltip'>${datas[i].xq==null?"":datas[i].xq}</td>
				<td data-toggle='tooltip'>${datas[i].jg==null?"":datas[i].jg}</td>
				<td data-toggle='tooltip'><a href="ttest/${datas[i].susId}"  style="cursor:pointer">${datas[i].file_name==null?"":datas[i].file_name}</a></td>
				<td> 
					<div style='text-align:center'> 
						<i onclick='showEdit(${datas[i].susId})'   title='编辑' style='color:#5bc0de;font-size:18px;cursor:pointer' class='fa fa-edit'></i>&nbsp;&nbsp; 
						<i onclick='showDetail(${datas[i].susId})' title='详情' style='color:#51C1C2;font-size:18px;cursor:pointer' class='fa fa-reorder'></i>&nbsp;&nbsp; 
						<i onclick='deleteData(${datas[i].susId})' title='删除' style='color:#F1817F;font-size:18px;cursor:pointer' class='fa fa-trash-o'></i> 
					</div> 
				</td>
			</tr>`
		);
		
	});
	//$("[data-toggle='tooltip']").tooltip();
}

//案件详情信息
function showDetail(infoId){
	layer.open({
		type:2,
		area:['60%','75%'],
		content:"publicData?id="+infoId
	});
}

//编辑页面
function showEdit(infoId){
	layer.open({
		type:2,
		area:['70%','75%'],
		content:"editData?id="+infoId
	});
}
//删除信息
function deleteData(infoId){
	layer.confirm("确认删除吗？",{icon:3,title:'提示信息'},function(index){
		$.ajax({
			url:'deleteInfoById',
			dataType:'json',
			type:"POST",
			data:{"infoId":infoId},
			success:function(data){
				if(data.state=="success"){
					page();
					layer.msg("删除成功");
				}
			},
			error:function(){
				layer.msg("删除失败！");
			}
		});
	});
	/*$.ajax({
		url:'deleteInfoById',
		data:{infoId:infoId},
		su
	});*/
}

//下载附件
function downLoadFile(e){
	var file_name=$(e).text();
	
}

