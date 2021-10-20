$(function(){
    $("nav li").on("click", function(){
        // this: JS에서 e.currentTarget
        const className = $(this).attr("class")
        const tagId = $(this).attr("id")
        const tagName = $(this).attr("name")
        const text = $(this).text()

        /*
        JS Debugging
        여러 개 변수 데이터를 alert()로 보고싶을 때 데이터들을 JSON 객체로 만들고
        JSON.stringify() 문자열로 바꿔서 alert()에 표시
        */
        const tagInfo = {
            tagName, tagId, className, text
        }

        alert(JSON.stringify(tagInfo))
    })
})