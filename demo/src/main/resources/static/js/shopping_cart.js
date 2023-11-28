sessionStorage=window.sessionStorage;

$('document').ready(function (){
    let is=isLogin();
    console.log(is);
    if(is)
    {
        let id=sessionStorage.getItem("userId");
        queryCart(1,10);
    }



})
function isLogin()
{
    let result=false;
    $.ajax({
        type:'get',
        // url:'user/isLogin',
        url:'./testJson/isLogin.json',
        data:{},
        dataType:'json',
        async:false,
        success:function (res)
        {
            if(res.code===200)
            {
                $('#cartNoLogin').hide();
                $('#cartLogin').show();
                $('#nickName').html("你好! "+res.data.nickName);
                sessionStorage.setItem("userId",res.data.id);
                result=true;
            }
            else{
                $('#cartNoLogin').show();
                $('#cartLogin').hide();
                result=false;
            }
        }
    })
    return result;
}
function queryCart(pn,pz)
{
    console.log("search :"+pz+"page");
    let id =sessionStorage.getItem('userId');
    $.ajax({
        type:'get',
        // url:'./cart/list/',
        url:'./testJson/shopcart.json',
        data:{
            userId:id,
            pageNum:pn,
            pageSize:pz
        },
        dataType:'json',
        success:function(res)
        {
            if(res.code===200)
            {
                console.log(res.data);
                let s="";
                for(var record of res.data)
                {
                    s+=
                    `<ul class="cartul2">
                <li class="cartli1">
                    <div class="cartd3">
                        <input type="checkbox">&nbsp;全选
                    </div>
                </li>
                <li class="cartli2">
                    <div class="flow-left"><img src="`+record.img+`"alt="product1"></div>
                    <div class="flow-left cartd5">`+record.prodName+`</div>
                    <div class="cls"></div>
                </li>
                <li class="cartli3">￥`+record.price+`</li>
                <li class="cartli4">
                    <button>-</button>
                    <input type="text" value="`+record.num+`">
                    <button class="ml">+</button>
                </li>
                <li class="cartli5">￥<span>`+(record.num*record.price)+`</span></li>
                <li class="cartli6"><a href="javascript:;">删除</a></li>
            </ul>`;
                }
                $('.cartd4').append(s);
            }
        }
    })

}