$(function(){

    $("nav li").on("click",function(){
        const className = $(this).attr("class")

        let href = `${rootPath}`

        location.href = `${href}${className}`
    })
})