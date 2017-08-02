/**
 * Created by xuebj on 2017/4/20.
 */
var TrainApplyModel = function ($){

    var Service = {
        _get:function (id){
            Ajax.query("getTrain",{
                url:"/apply/train/get",
                data:{id:id},
                callback:function (result) {
                    $("#contentName").text(result.title);
                    $("#contentId").val(result.id);
                }
            })
        }
    }


    function _initForm(){
        $("#applyForm").Validform({
            tiptype:3,
            callback:function (form){
                Ajax.submit("apply",{
                    url:"/apply/train",
                    data:Tool.serializeJson(form),
                    callback:function () {
                        Tool.layer_alert("报名成功",function (){
                            window.location.href = "./index.htm?type=2";
                        })
                    }
                })
                return false;
            }
        })
    }
    $(function () {
        Service._get(Tool.getReqP("id"));
        _initForm();
    })
}(jQuery)
