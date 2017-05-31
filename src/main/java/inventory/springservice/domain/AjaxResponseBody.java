package inventory.springservice.domain;

import java.util.List;

public class AjaxResponseBody {

    String msg;
    List<SysUser> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SysUser> getResult() {
        return result;
    }

    public void setResult(List<SysUser> result) {
        this.result = result;
    }

}
