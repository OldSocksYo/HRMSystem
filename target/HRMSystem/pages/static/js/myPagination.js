/**
 * 分页设置
 * @param pageNum 当前页
 * @param total 数据总数量
 * @param pageSize 每页的数据的大小
 * @param action 将要请求的Controller
 */
function myPagination(pageNum, total, pageSize, action){
    //分页设置
    $('.pagination-box').pagination({
        current: pageNum,
        totalData: total,
        showData: pageSize,
        count:2,
        coping: true,
        callback: function (index) {
            window.location.href = action + "?pageNum=" + index.getCurrent() + "&pageSize=" + pageSize;
            // $.ajax({
            //     url:"getEmployees",
            //     type:"POST",
            //     data: "pageNum=" + index.getCurrent() + "&pageSize=" + pageSize,
            //     dataType:"html",
            //     success:function (data){
            //         $("#right").html(data);
            //     }
            // });
        }
    });
}


