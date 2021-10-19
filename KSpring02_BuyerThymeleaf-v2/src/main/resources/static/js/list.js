//JQuery 사용할 때
//$(document.ready(function(){
//})
$(function(){
//JQuery 코드 영역
//        $("table.list tr").on("click", function(){
//    $("table.list tr").on("click", function() {
//        const id = $(this).data("id")
//        alert(id)
//        location.href="/detail?m_id=" + id
//    })
    function tableClickHandler() {
        const id = $(this).data("id")
        location.href="/detail?m_id="+id
    }
    $("table.list tr").on("click", tableClickHandler)
})