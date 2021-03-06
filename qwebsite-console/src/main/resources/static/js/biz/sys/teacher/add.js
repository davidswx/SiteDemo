var PartnerAdd = function (){
    var now = Tool.dateFormat(new Date().getTime());
    $("#releaseDate").val(now);
    var Service = {
        queryEnabledFlagType:function () {
            Ajax.query("queryEnabledFlagList",{
                url:"/sys_dict_item/list_by_entry_code",
                data:{entryCodes:"isShow,teacherType,teacherLevel"},
                callback:function (result) {
                    $("select[name='isEnabled']").html(template("selected_temp",{list:result["isShow"]})).fancyspinbox();
                    $("select[name='type']").html(template("selected_temp",{list:result["teacherType"]})).fancyspinbox();
                    $("select[name='level']").html(template("selected_temp",{list:result["teacherLevel"]})).fancyspinbox();
                }
            })
        }
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url:path + '/teacher/save',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在上传");
                    },  //提交前处理
                    success:function () {
                        Tool.layer_alert("保存成功",function(){
                            Tool.go_back();
                        });
                    },  //处理完成
                    resetForm:false,
                    type:'POST',
                    dataType:'json'
                };

                $("#form1").ajaxSubmit(options);

                return false;
            }
        });
    }

    $(function(){
        var ue = UE.getEditor('txt');
        Service.queryEnabledFlagType();
        _initForm();
    });

}();