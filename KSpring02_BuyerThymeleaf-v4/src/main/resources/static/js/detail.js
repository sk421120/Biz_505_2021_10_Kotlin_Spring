$(function(){
    const detail_button = $("section.buyer_detail button")

    const order_button = $("section.order_detail button")

    if(detail_button) {
        $(detail_button).on("click",function(){
            const className = $(this).attr("class")
            let href = `${rootPath}buyer`
            if(className.includes("btn_update")) {
//                 alert(`Update ${userid}`)
                href = `${href}/update/${userid}`
            } else if(className.includes("btn_delete")) {
//                 alert(`Delete ${userid}` )
                href = `${href}/delete/${userid}`
                if( !confirm("삭제할까요?") ) {
                    return false
                }
            }
            location.href = `${href}`
        })
    }
    if(order_button) {
        $(order_button).on("click",function(){
            const className = $(this).attr("class")
            let href = `${rootPath}order`
            if(className.includes("btn_update")) {
//                alert(`Update ${seq}`)
                href = `${href}/update/${seq}`
            } else if(className.includes("btn_delete")) {
//                alert(`Delete ${seq}`)
                href = `${href}/delete/${seq}`
                if( !confirm("삭제할까요?") ) {
                    return false
                }
            }
            location.href = `${href}`
        })
    }
})