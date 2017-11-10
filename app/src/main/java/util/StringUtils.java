package util;

import android.annotation.SuppressLint;
import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 
 * ClassName: StringUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015-5-23 上午10:23:37 <br/>
 * 字符串操作工具包
 * 
 * @author hao
 * @version
 * @since JDK 1.6
 */
public class StringUtils
{
	private final static Pattern emailer = Pattern
			.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
	private final static Pattern phone = Pattern
			.compile("(^1[3|4|5|7|8][0-9]{9}$)");
	private final static Pattern phonenumber = Pattern
			.compile("((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)");
	private final static Pattern idcard = Pattern
			.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
	private final static Pattern is_it_legal = Pattern
			.compile("^[\u4e00-\u9fa5_a-zA-Z0-9-]+$");
	private final static Pattern isWatch = Pattern.compile("^(86731300)\\d{7}$");
	private final static Pattern isGPS_Glu = Pattern.compile("[0-9]{10}");
	private final static Pattern isGPS_Pre = Pattern.compile("[0-9]{15}");
	
	/**
	 * 
	 * @Title: isEmpty
	 * @Description: 判断给定字符串是否空白串 空白串是指由空格、制表符、回车符、
	 *               换行符组成的字符串 若输入字符串为null或空字符串，返回true
	 * @param @param input
	 * @param @return 参数说明
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isEmpty(CharSequence input)
	{
		if (input == null || "".equals(input)) return true;
		
		for (int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			if (c != ' ' && c != '\t' && c != '\r' && c != '\n')
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @Title: isLegal
	 * @Description: 验证是否合法
	 * @param @param name
	 * @param @return
	 * @author yh
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isLegal(CharSequence name)
	{
		if (isEmpty(name)) return false;
		return is_it_legal.matcher(((String)name).trim()).matches();
	}
	
	/**
	 * 
	 * @Title: isWatch
	 * @Description: 判断是否是手表
	 * @param @param name
	 * @param @return
	 * @author hjl
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isWatch(CharSequence name)
	{
		if (isEmpty(name)) return false;
		return isWatch.matcher(name).matches();
	}
	/**
	 * 
	* @Title: isGPRS_Glu 
	* @Description: GPRS血压
	* @param @param name
	* @param @return   
	  @author 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isGPRS_Pre(CharSequence name)
	{
		if (isEmpty(name)) return false;
		return isGPS_Pre.matcher(name).matches();
	}
	
	
	/**
	 * 
	* @Title: isGPRS_Glu 
	* @Description: GPRS血糖
	* @param @param name
	* @param @return   
	  @author 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isGPRS_Glu(CharSequence name)
	{
		if (isEmpty(name)) return false;
		return isGPS_Glu.matcher(name).matches();
	}
	
	/**
	 * 
	 * @Title: empty
	 * @Description: 判断所有对象是否为空
	 * @param @param obj
	 * @param @return 参数说明
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isEmpty(Object obj)
	{
		if (null == obj)
		{
			return true;
		}
		else if ((obj instanceof String) && "".equals(obj))
		{
			return true;
		}
		else if ((obj instanceof Number) && ((Number) obj).doubleValue() == 0)
		{
			return true;
		}
		else if ((obj instanceof Collection<?>)
				&& ((Collection<?>) obj).isEmpty())
		{
			return true;
		}
		else if ((obj instanceof Map<?, ?>) && ((Map<?, ?>) obj).isEmpty())
		{
			return true;
		}
		else if ((obj instanceof Object[]) && ((Object[]) obj).length == 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @Title: jointToStringID
	 * @Description: 根据资源ID拼接字符串
	 * @param @param mContext
	 * @param @param vlue
	 * @param @param index
	 * @param @param id
	 * @param @return 参数说明
	 * @return String 返回类型
	 * @throws
	 */
	public static String jointToStringID(Context mContext, String vlue,
			int index, int... id)
	{
		StringBuffer vlues = new StringBuffer();
		for (int i = 0; i < id.length; i++)
		{
			vlues.append(mContext.getString(id[i]));
		}
		vlues.insert(index, vlue);
		return vlues.toString();
	}
	
	/**
	 * 
	 * @Title: isEmail
	 * @Description: 判断是不是一个合法的电子邮件地址
	 * @param @param email
	 * @param @return 参数说明
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isEmail(CharSequence email)
	{
		if (isEmpty(email)) return false;
		return emailer.matcher(email).matches();
	}
	
	/**
	 * 
	 * @Title: isPhone
	 * @Description: 判断是不是一个合法的手机号码
	 * @param @param phoneNum
	 * @param @return 参数说明
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isPhone(CharSequence phoneNum)
	{
		if (isEmpty(phoneNum)) return false;
		return phone.matcher(phoneNum).matches();
	}
	
	/**
	 * 
	 * @Title: isPhone
	 * @Description: 判断是不是一个合法的手机号码或者座机
	 * @param @param phoneNum
	 * @param @return 参数说明
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isPhoneNumber(CharSequence phoneNum)
	{
		if (isEmpty(phoneNum)) return false;
		return phonenumber.matcher(phoneNum).matches();
	}
	
	/**
	 * 
	 * @Title: isIdcard
	 * @Description: 判断是不是一个合法的身份证号码
	 * @param @param idCard
	 * @param @return
	 * @author hjl
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isIdcard(CharSequence idCard)
	{
		if (isEmpty(idCard)) return false;
		return idcard.matcher(idCard).matches();
	}
	
	/**
	 * idcard
	 * 
	 * @Title: getDataTime
	 * @Description: 返回当前系统时间
	 * @param @param format
	 * @param @return 参数说明
	 * @return String 返回类型
	 * @throws
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getDataTime(String format)
	{
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(new Date());
	}
	
	/**
	 * 字符串转整数
	 * 
	 * @param str
	 * @param defValue
	 * @return
	 */
	public static int toInt(String str, int defValue)
	{
		try
		{
			return Integer.parseInt(str);
		}
		catch (Exception e)
		{
		}
		return defValue;
	}
	
	/**
	 * 对象转整
	 * 
	 * @param obj
	 * @return 转换异常返回 0
	 */
	public static int toInt(Object obj)
	{
		if (obj == null) return 0;
		return toInt(obj.toString(), 0);
	}
	
	/**
	 * String转long
	 * 
	 * @param obj
	 * @return 转换异常返回 0
	 */
	public static long toLong(String obj)
	{
		try
		{
			return Long.parseLong(obj);
		}
		catch (Exception e)
		{
		}
		return 0;
	}
	
	/**
	 * String转double
	 * 
	 * @param obj
	 * @return 转换异常返回 0
	 */
	public static double toDouble(String obj)
	{
		try
		{
			return Double.parseDouble(obj);
		}
		catch (Exception e)
		{
		}
		return 0D;
	}
	
	/**
	 * 字符串转布尔
	 * 
	 * @param b
	 * @return 转换异常返回 false
	 */
	public static boolean toBool(String b)
	{
		try
		{
			return Boolean.parseBoolean(b);
		}
		catch (Exception e)
		{
		}
		return false;
	}
	
	/**
	 * 判断一个字符串是不是数字
	 */
	public static boolean isNumber(CharSequence str)
	{
		try
		{
			Integer.parseInt(str.toString());
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * byte[]数组转换为16进制的字符串。
	 * 
	 * @param data
	 *        要转换的字节数组。
	 * @return 转换后的结果。
	 */
	public static final String byteArrayToHexString(byte[] data)
	{
		StringBuilder sb = new StringBuilder(data.length * 2);
		for (byte b : data)
		{
			int v = b & 0xff;
			if (v < 16)
			{
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase(Locale.getDefault());
	}
	
	/**
	 * 16进制表示的字符串转换为字节数组。
	 * 
	 * @param s
	 *        16进制表示的字符串
	 * @return byte[] 字节数组
	 */
	public static byte[] hexStringToByteArray(String s)
	{
		int len = s.length();
		byte[] d = new byte[len / 2];
		for (int i = 0; i < len; i += 2)
		{
			// 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节
			d[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
					.digit(s.charAt(i + 1), 16));
		}
		return d;
	}
	
	private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>()
	{
		@SuppressLint("SimpleDateFormat")
		@Override
		protected SimpleDateFormat initialValue()
		{
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	
	private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>()
	{
		@SuppressLint("SimpleDateFormat")
		@Override
		protected SimpleDateFormat initialValue()
		{
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	
	/**
	 * 以友好的方式显示时间
	 * 
	 * @param sdate
	 * @return
	 */
	public static String friendlyTime(String sdate)
	{
		Date time = null;
		
		if (isInEasternEightZones())
		{
			time = toDate(sdate);
		}
		else
		{
			time = transformTime(toDate(sdate), TimeZone.getTimeZone("GMT+08"),
					TimeZone.getDefault());
		}
		
		if (time == null)
		{
			return "Unknown";
		}
		String ftime = "";
		Calendar cal = Calendar.getInstance();
		
		// 判断是否是同一天
		String curDate = dateFormater2.get().format(cal.getTime());
		String paramDate = dateFormater2.get().format(time);
		if (curDate.equals(paramDate))
		{
			int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
			if (hour == 0) ftime = Math.max(
					(cal.getTimeInMillis() - time.getTime()) / 60000, 1)
					+ "分钟前";
			else ftime = hour + "小时前";
			return ftime;
		}
		
		long lt = time.getTime() / 86400000;
		long ct = cal.getTimeInMillis() / 86400000;
		int days = (int) (ct - lt);
		if (days == 0)
		{
			int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
			if (hour == 0) ftime = Math.max(
					(cal.getTimeInMillis() - time.getTime()) / 60000, 1)
					+ "分钟前";
			else ftime = hour + "小时前";
		}
		else if (days == 1)
		{
			ftime = "昨天";
		}
		else if (days == 2)
		{
			ftime = "前天 ";
		}
		else if (days > 2 && days < 31)
		{
			ftime = days + "天前";
		}
		else if (days >= 31 && days <= 2 * 31)
		{
			ftime = "一个月前";
		}
		else if (days > 2 * 31 && days <= 3 * 31)
		{
			ftime = "2个月前";
		}
		else if (days > 3 * 31 && days <= 4 * 31)
		{
			ftime = "3个月前";
		}
		else
		{
			ftime = dateFormater2.get().format(time);
		}
		return ftime;
	}
	
	/**
	 * 将字符串转位日期类型
	 * 
	 * @param sdate
	 * @return
	 */
	public static Date toDate(String sdate)
	{
		return toDate(sdate, dateFormater.get());
	}
	
	public static Date toDate(String sdate, SimpleDateFormat dateFormater)
	{
		try
		{
			return dateFormater.parse(sdate);
		}
		catch (ParseException e)
		{
			return null;
		}
	}
	
	/**
	 * 判断用户的设备时区是否为东八区（中国） 2014年7月31日
	 * 
	 * @return
	 */
	public static boolean isInEasternEightZones()
	{
		boolean defaultVaule = true;
		if (TimeZone.getDefault() == TimeZone.getTimeZone("GMT+08")) defaultVaule = true;
		else defaultVaule = false;
		return defaultVaule;
	}
	
	/**
	 * 根据不同时区，转换时间 2014年7月31日
	 */
	public static Date transformTime(Date date, TimeZone oldZone,
			TimeZone newZone)
	{
		Date finalDate = null;
		if (date != null)
		{
			int timeOffset = oldZone.getOffset(date.getTime())
					- newZone.getOffset(date.getTime());
			finalDate = new Date(date.getTime() - timeOffset);
		}
		return finalDate;
	}
	
	/**
	 * 
	 * @Title: generateFileName
	 * @Description: 随机生成一个文件名称
	 * @param @param path 下载路径
	 * @param @param fileExtension 文件扩展名
	 * @param @return 文件路径
	 * @author yh
	 * @return String 返回类型
	 * @throws
	 */
//	public static String generateFileName(String path, String fileExtension)
//	{
//		final File folder = FileUtils.getSaveFolder(path);
//		return folder + File.separator + UUID.randomUUID().toString()
//				+ fileExtension;
//	}
	/**
	 * 
	* @Title: getFileName 
	* @Description: 随机生成一个文件名称 不包含路径
	* @param @param fileExtension 文件扩展名
	* @param @return
	  @author yh
	* @return String    返回类型 
	* @throws
	 */
	public static String getFileName(String fileExtension)
	{
		return UUID.randomUUID().toString()
		+ fileExtension;
	}
	
	/**
	 * 
	 * @Title: isLimit
	 * @Description: 限制字符串字数
	 * @param @param msg 内容
	 * @param @param szie 限制长度
	 * @param @return
	 * @author hjl 作者
	 * @return String 返回类型
	 * @throws
	 */
	public static String isLimit(String msg, int szie)
	{
		String content = msg;
		if (!isEmpty(content))
		{
			content = content.replace("\n", "");
			if (content.length() > szie)
			{
				return content.substring(0, szie - 1) + "..";
			}
		}
		else
		{
			content = "";
		}
		return content;
	}
	
}
