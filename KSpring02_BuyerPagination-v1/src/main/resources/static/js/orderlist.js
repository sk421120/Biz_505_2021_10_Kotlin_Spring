$(()=>{
    function tableClickHandlerOrder() {
        const seq = $(this).data("seq")
        location.href = "/order/detail?seq=" + seq
    }

    $("table.order_list tr").on("click", tableClickHandlerOrder)

})
