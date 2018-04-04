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
		url:"dataSearch",
		dataType:"json",
		data:{
			pageNo: curr || 1,
			pageSize: pageSize,
			jjdbh:$('input[name="jjdbh"]').val(),
			bjdh:$('input[name="bjdh"]').val(),
			bjrxm:$('input[name="bjrxm"]').val(),
			jjy:$('input[name="jjy"]').val()
			},
		type:"POST",
		success:function(data){
			searchAll(data,pageSize,curr);
		},
		error:function(){
			alert("请求查询数据错误");
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
			"<tr>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].jjdbh+"'>"+datas[i].jjdbh+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].bjsj_format+"'>"+datas[i].bjsj_format+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].gjz+"'>"+datas[i].gjz+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].afdz+"'>"+datas[i].afdz+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].zafsCode+"'>"+datas[i].zafsCode+"</td>"+
				/*"<td data-toggle='tooltip' data-container='body' title='"+datas[i].zpsdflCode+"'>"+datas[i].zpsdflCode+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].zpsddlCode+"'>"+datas[i].zpsddlCode+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].zpsdxlCode+"'>"+datas[i].zpsdxlCode+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].jjy+"'>"+datas[i].jjy+"</td>"+*/
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].bjrxm+"'>"+datas[i].bjrxm+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].bjrxb+"'>"+datas[i].bjrxb+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].bjdh+"'>"+datas[i].bjdh+"</td>"+
				"<td data-toggle='tooltip' data-container='body' title='"+datas[i].bjnr+"'>"+datas[i].bjnr+"</td>"+
				"<td>" +
					"<div style='text-align:center'>" +
						"<i onclick='showEdit("+datas[i].id+")' data-toggle='tooltip' data-container='body' title='编辑' style='color:#5bc0de;font-size:18px;cursor:pointer' class='fa fa-edit'></i>&nbsp;&nbsp;" +
						"<i onclick='showDetail("+datas[i].id+")' data-toggle='tooltip' data-container='body' title='详情' style='color:#51C1C2;font-size:18px;cursor:pointer' class='fa fa-reorder'></i>&nbsp;&nbsp;" +
						"<i onclick='deleteData("+datas[i].id+")' data-toggle='tooltip' data-container='body' title='删除' style='color:#F1817F;font-size:18px;cursor:pointer' class='fa fa-trash-o'></i>" +
					"</div>" +
				"</td>"+
			"</tr>"
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

