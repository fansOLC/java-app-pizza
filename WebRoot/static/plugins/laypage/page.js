$('#page').append('<div id="demo4" style="text-align:center"></div><div id="sort" style="position:absolute;left:16px;top:10px;"></div>');
//分页函数

function pageDetail(data,pageSize,curr){
	data=data.page;
	laypage({
        cont: 'demo4', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
        pages: data.pageCount, //通过后台拿到的总页数
        curr: curr || 1,
        first: 1, //若不显示，设置false即可
        last: data.pageCount, //若不显示，设置false即可
        //prev: '<', //若不显示，设置false即可
        //next: '>', //若不显示，设置false即可
        skip:true,
        groups:4,
        skin:'#5BC0DE',
        jump: function (obj,first) { //触发分页后的回调
            if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                page(obj.curr);
            }
        }
    });
    $('#page').css('display','block');
    $('#sort').html('');
    $('#sort').append('<p class="red">共'+data.count+'条&nbsp;&nbsp;&nbsp;&nbsp;共'+data.pageCount+'页&nbsp;&nbsp;&nbsp;&nbsp;当前第'+(data.pageNo)+'页</p>');
}