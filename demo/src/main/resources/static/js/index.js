var category_arr=[];
var goodsMap={}
$(document).ready(function (){
    // console.log(23);
    queryCategory();

    // $('#c1').on("mouseover",function (){
    //     console.log(456);
    //     $("#c1 .cg-a").css("background-color","#e9e9e9");
    //     $('#c1 .cg-div').show();
    // })
    // $('#c1').on("mouseleave",function (){
    //     console.log(999);
    //     $("#c1 .cg-a").css("background-color","white");
    //     $('#c1 .cg-div').hide();
    // })
    // $('#c2').on("mouseover",function (){
    //     console.log(456);
    //     $("#c2 .cg-a").css("background-color","#e9e9e9");
    //     $('#c2 .cg-div').show();
    // })
    // $('#c2').on("mouseleave",function (){
    //     console.log(999);
    //     $("#c2 .cg-a").css("background-color","white");
    //     $('#c2 .cg-div').hide();
    // })
})

function queryCategory()
{
    $.ajax({
        // url:'/category/list',
        url:'./testJson/category.json',
        type:'get',
        data:'',
        dataType:'json',
        success:function (res)
        {
            if(res.code===200)
            {
                // console.log(res.data);
                category_arr=res.data;
                let s1="";
                for (let val of category_arr){
                   s1+=`<div class='category ' cgId='`+val.id+`'>
                       <div class='cg-a'><a href='javascript:;'>`+val.name+`</a></div>
                   </div>`;

                }
                $('#category-p').append(s1);
                for (let val of category_arr)
                {
                    // console.log("w1");
                    queryGoodsByCategoryId(val.id,val.name,1,1);
                }
            }
        }
    })
}
function queryGoodsByCategoryId(cgId,cgName,pn,pz)
{
    $.ajax({
        type:'get',
        url:'/product/list',

        // data: {
        //     categoryId: cgId,
        //     name: cgName,
        //     pageNum: pn,
        //     pageSize: pz
        // },
        data:'',
        dataType: 'json',
        success:function (res)
        {

            console.log("this is "+res.data);
            if(res.code===200)
            {
                goodsMap[cgName]=res.data;
                console.log(goodsMap);
                let s1="";
                s1+=`
                <div class="cg-div">
                    <div class="category-detail">`;
                let i=0;
                for(let val of goodsMap[cgName])
                {
                    if(i===0)
                    {
                        s1+='<ul>';
                    }

                    s1+=`<li class="cd_li"><a href="./goods.html?id=`+val.id+`">`+val.title+`</a> </li>`;
                    i++;
                    if(i===6)
                    {
                        s1+='</ul>';
                        i=0;
                    }
                }
                if(i!==0)
                {
                    s1+='</ul>';
                }
                s1+=`
                        </div>
                </div>`;
                $("div[cgId='"+cgId+"']").append(s1);
                $("div[cgId='"+cgId+"']").on("mouseover",function (){
                    // console.log(456);
                    $("div[cgId='"+cgId+"'] .cg-a").css("background-color","#e9e9e9");
                    $("div[cgId='"+cgId+"'] .cg-div").show();
                })
                $("div[cgId='"+cgId+"']").on("mouseleave",function (){
                    // console.log(999);
                    $("div[cgId='"+cgId+"'] .cg-a").css("background-color","white");
                    $("div[cgId='"+cgId+"'] .cg-div").hide();
                })
                // console.log("div");
            }

        },
        error: function(xhr, status, error) {
            console.error("AJAX request failed:", status, error);
        }

    })
}