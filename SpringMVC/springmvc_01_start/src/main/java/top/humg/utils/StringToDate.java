package top.humg.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//把字符串转为日期
public class StringToDate implements Converter<String, Date> {
    /**
     * @param source 传入字符串参数
     * @return 返回转换成的Date对象
     */
    @Override
    public Date convert(String source) {
        if (source == null) {
            throw new RuntimeException("请传入非空字符串");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期格式化错误");
        }
    }
}
