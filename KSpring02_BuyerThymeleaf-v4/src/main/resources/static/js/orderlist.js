$(()=>{
    function tableClickHandlerOrder() {
        const seq = $(this).data("seq")
        location.href = `${rootPath}/order/detail?seq=${seq}`
    }

    $("table.order_list tbody tr").on("click", tableClickHandlerOrder)

})
