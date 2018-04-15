package com.base.api.common.web.controller;

import com.base.api.common.ConfigUtil;
import com.base.api.common.constants.Constants;
import com.base.api.common.domain.ResultBody;
import com.base.api.common.enums.PlatformEnums;
import com.base.api.common.enums.ResCodeEnums;
import com.base.api.common.utils.StrUtils;
import com.base.api.common.web.RequestHeaderEnums;
import com.base.api.common.web.model.TokenData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author xiaohai
 * @date:  2017年3月7日 下午4:59:07   
 *
 */
public abstract class BaseController {

    /**
     * 验证请求参数
     *
     * @param result
     * @param bind
     * @return
     */
    public ResultBody validateResult(ResultBody result, BindingResult bind) {
        if (bind.hasErrors ()) {
            result.setResMsg (bind.getAllErrors ().get (0).getDefaultMessage ());
            result.setResCode (ResCodeEnums.ERROR.getResCode ());
        }
        return result;
    }

    /**
     * 用户
     *
     * @param request
     * @return
     */
    public TokenData getUserToken(HttpServletRequest request) {
        return (TokenData) request.getAttribute (Constants.USER_DATA);
    }

    /**
     * Id
     *
     * @param request
     * @return
     */
    public Long getMemberId(HttpServletRequest request) {
        TokenData user = getUserToken (request);
        if (user != null) {
            return user.getId ();
        }
        return 0L;
    }

    /**
     * Id
     *
     * @param request
     * @return
     */
    public Long getMemberIdMayNull(HttpServletRequest request) {
        TokenData user = getUserToken (request);
        if (user != null) {
            return user.getId ();
        }
        return null;
    }


    /**
     * 手机号
     *
     * @param request
     * @return
     */
    public String getUserMobile(HttpServletRequest request) {
        TokenData user = getUserToken (request);
        if (user != null) {
            return user.getMobile ();
        }
        return null;
    }

    /**
     * 获取登录设备
     *
     * @param req
     * @return
     */
    protected String getRequestDevice(HttpServletRequest req) {
        return req.getHeader (RequestHeaderEnums.REQ_HEADER_DEVICE.getHeader ());
    }

    /**
     * 获取登录设备类型
     *
     * @param req
     * @return
     */
    protected PlatformEnums getRequestClientSource(HttpServletRequest req) {
        String deviceType = req.getHeader (RequestHeaderEnums.REQ_HEADER_DEVICE_TYPE.getHeader ());
        if (StringUtils.isNotBlank (deviceType) && StringUtils.isNumeric (deviceType)) {
            return PlatformEnums.getClient (Integer.parseInt (deviceType));
        }
        return PlatformEnums.OTHER;
    }

	/**
	 * 获取登录设备类型
	 *
	 * @param req
	 * @return
	 */
	protected String getBusway(HttpServletRequest req) {
		String deviceType = req.getHeader(RequestHeaderEnums.REQ_HEADER_DEVICE_TYPE.getHeader());
		if (StringUtils.isNotBlank(deviceType) && StringUtils.isNumeric(deviceType)) {
			Integer val =PlatformEnums.getClient(Integer.parseInt(deviceType)).getValue();
			if (val== 4){
				return "00";
			}else {
				return "01";
			}
		}
		return "03";
	}
	/**
	 * 获取设备ID
	 * @param req
	 * @return
	 */
	protected String getRequestDeviceId(HttpServletRequest req) {
		String deviceId = req.getHeader(RequestHeaderEnums.REQ_HEADER_DEVICE_ID.getHeader());
		if (StringUtils.isNotBlank(deviceId)) {
			return deviceId;
		}
		return null;
	}

    /**
     * 获得推送编号
     *
     * @param req
     * @return
     */
    protected String getRequestPushId(HttpServletRequest req) {
        return req.getHeader (RequestHeaderEnums.REQ_HEADER_PUSH_ID.getHeader ());
    }

    /**
     * 渠道
     *
     * @param req
     * @return
     */
    protected String getRequestChannelSource(HttpServletRequest req) {
        String channel = req.getHeader (RequestHeaderEnums.REQ_HEADER_CHANNEL_SOURCE.getHeader ());
        if (channel == null || (channel != null && channel.length () == 0)) {
            channel = ConfigUtil.getInstance ().getDefaultChannel ();
        }
        return channel;
    }

    /**
     * 获取客户端IP
     *
     * @throws
     * @Title: getRequestClientIP
     * @Description: TODO
     * @param: @param request
     * @param: @return
     * @return: String
     */
    public String getRequestClientIP(HttpServletRequest request) {
        PlatformEnums client = getRequestClientSource (request);
        if (client.getValue () == PlatformEnums.H5.getValue ()) {// h5过来的界面ip需要特殊处理
            String ip = request.getParameter ("ip");
            if (StringUtils.isNoneBlank (ip)) {
                return ip;
            }
            ip = request.getHeader ("ip");
            if (StringUtils.isNotEmpty (ip)) {
                return ip;
            }
        }
        String ip = request.getHeader ("x-forwarded-for");
        if (ip == null || ip.length () == 0 || "unknown".equalsIgnoreCase (ip)) {
            ip = request.getHeader ("Proxy-Client-IP");
        }
        if (ip == null || ip.length () == 0 || "unknown".equalsIgnoreCase (ip)) {
            ip = request.getHeader ("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length () == 0 || "unknown".equalsIgnoreCase (ip)) {
            ip = request.getRemoteAddr ();
        }
        if (StringUtils.isNotBlank (ip) && ip.indexOf (",") > 0) {
            ip = ip.substring (0, ip.indexOf (","));
        }
        return ip;
    }

    /**
     * @param req
     * @return
     */
    public boolean isWebPay(HttpServletRequest req) {
        return false;
    }

    /**
     * 是否IOS设备
     *
     * @param req
     * @return
     */
    public boolean isIOS(HttpServletRequest req) {
        PlatformEnums clientSource = getRequestClientSource (req);
        if (clientSource.getValue () == PlatformEnums.IOS.getValue ()) {
            return true;
        }
        return false;
    }

    /**
     * 获取设备序列
     *
     * @param req
     * @return
     */
    protected String getRequestDeviceImei(HttpServletRequest req) {
        String deviceImei = req.getHeader (RequestHeaderEnums.REQ_HEADER_DEVICE_ID.getHeader ());
        if (StrUtils.isNotBlank (deviceImei)) {
            return deviceImei;
        }
        return null;
    }

    /**
     * 获取登录设备类型
     *
     * @param req
     * @return
     */
    protected Short getRequestDeviceType(HttpServletRequest req) {
        String deviceType = req.getHeader (RequestHeaderEnums.REQ_HEADER_DEVICE_TYPE.getHeader ());
        if (StrUtils.isNotBlank (deviceType)
                && StrUtils.isNumeric (deviceType)) {
            return Short.valueOf (deviceType);
        }
        return -1;
    }

    /**
     * 获取设备序列
     *
     * @param req
     * @return
     */
    protected String getRequestDeviceSerialNumber(HttpServletRequest req) {
        return req.getHeader (RequestHeaderEnums.REQ_HEADER_DEVICE_ID.getHeader ());
    }

    /**
     * 获取设备通道
     * <p>
     * 00：PC端；01：手机端；
     * 02：Pad端；03：其它
     *
     * @param req
     * @return
     */
    protected String getBusWay(HttpServletRequest req) {
        PlatformEnums platformEnum = getRequestClientSource (req);
        if (platformEnum.equals (PlatformEnums.Android) || platformEnum.equals (PlatformEnums.H5) || platformEnum.equals (PlatformEnums.IOS)) {
            return "01";
        } else if (platformEnum.equals (PlatformEnums.PC)) {
            return "00";
        } else {
            return "03";
        }
//        return DeviceUtil.getBusWay (req.getHeader ("User-Agent"));
    }
}
