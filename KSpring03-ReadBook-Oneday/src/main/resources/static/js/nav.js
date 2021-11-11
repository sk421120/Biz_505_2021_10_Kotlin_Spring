$(function () {

    $("nav li").on("click", function () {
        const className = $(this).attr("class")

        let href = `${rootPath}`

        if (className == "logout") {
            location.post = `@{/logout}`
        }
        location.href = `${href}${className}`
    })
})