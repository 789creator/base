package com.base.api.common.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Legal nick name util.
 */
public class LegalNickNameUtil {

    private static List<String> minGanCiList;

    private static List<String> getSensitiveWordList() throws Exception {
        if (minGanCiList == null) {
            synchronized (LegalNickNameUtil.class) {
                if (minGanCiList == null) {
                    String fileName = "sensitiveVocabulary.txt";
                    String path = LegalNickNameUtil.class.getClassLoader().getResource(fileName).getPath();
                    File isfile = new File(path);
                    // 判断文件是否存在
                    if (!isfile.exists()) {
                        throw new RuntimeException("敏感词库文件不存在");
                    } else {
                        minGanCiList = FileUtils.readLines(isfile);
                    }
                }
            }
        }
        return minGanCiList;
    }

    /**
     * 返回true说明有敏感词
     *
     * @param nickName the nick name
     * @return boolean
     */
    public static Boolean nickNameFilter(String nickName) {
        try {
            List<String> minGanCiList = getSensitiveWordList();
            if (CollectionUtils.isNotEmpty(minGanCiList)) {
                for (String s : minGanCiList) {
                    if (nickName.contains(s)) {
                        return true;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return true;
        }
        return false;
    }

    /**
     * 过滤表情
     *
     * @param source the source
     * @return boolean
     */
    public static Boolean filterEmoji(String source) {

        if (source != null) {
            Pattern emoji = Pattern.compile("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]",
                    Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

            Matcher emojiMatcher = emoji.matcher(source);

            if (emojiMatcher.find()) {
                return true;
            }
            return false;
        }
        return false;

    }

    /**
     * 过滤表情
     *
     * @param source the source
     * @return string
     */
    public static String filterEmoji1(String source) {

        if (source != null) {
            Pattern emoji = Pattern.compile("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]",
                    Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

            Matcher emojiMatcher = emoji.matcher(source);

            if (emojiMatcher.find()) {
                source = emojiMatcher.replaceAll("");
                return source;
            }
            return source;
        }
        return source;

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Boolean l = new LegalNickNameUtil().nickNameFilter("");
        System.out.println(nickNameFilter("管理员"));
    }
}
