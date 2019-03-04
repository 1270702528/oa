package com.yucaijr.util;

import com.yucaijr.Enum.ErrorEnum;
import com.yucaijr.vo.ResultVO;

public class ResultVOUtil {

	public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(ErrorEnum errorEnum) {
        return error(errorEnum.getCode(),errorEnum.getMsg());
    }
    
    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
