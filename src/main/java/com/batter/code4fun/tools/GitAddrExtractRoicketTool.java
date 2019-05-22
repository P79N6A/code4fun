package com.batter.code4fun.tools;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GitAddrExtractRoicketTool {

    /**
     * 仓库们的根目录
     */
    public static final String Cd_Path = "cd /Users/wangning/go/src/wangning_test";
    /**
     * git
     */
    public static String[] urls = {
            "https://code.byted.org/rocket/admin_site.git",
            "https://code.byted.org/rocket/red_packet.git",

    };


    public static String urlFmtReg = "https://code\\.byted\\.org/rocket/(.)*?\\.git";
//    public static List<String> repos = new ArrayList<>();
    public static List<String> repos = Lists.newArrayList(urls);


    public static void main(String[] args) throws IOException {
        //step1: 给全局变量repos赋值
//        for (String url : urls) {
//            getRepoByPath(url);
//        }
        //step2: 调用git命令
        gitClone();
    }

    private static void getRepoByPath(String url) throws IOException {
        URL urlObj = new URL(url);
        URLConnection urlConnection = urlObj.openConnection();
        urlConnection.setRequestProperty("Cookie", "_gitlab_session=64dd8364da97eb65ece7de001b01a9df");
        InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        String repo = null;
        while ((line = br.readLine()) != null) {
//            System.out.println(line);
            Pattern p = Pattern.compile(urlFmtReg);
            Matcher matcher = p.matcher(line);
            if (matcher.find()) {
                repo = matcher.group();
                break;
            }
        }
        if (repo != null) {
            repos.add(repo);
            System.out.println(repo);
        }
    }

    private static void gitClone() {
        List<String> urls = repos;
        String cd = Cd_Path;
        String inter = " && ";
        String gitClone = "git clone ";
        String prefix = cd + inter + gitClone;
        for (String url : urls) {
            String target = prefix + url;
            shell(target);
        }
    }

    public static List<String> getUrls() {
        String str = "<li><a href=\"https://code.byted.org/gopkg/abtest\">abtest</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/grass\">grass</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/video\">video</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/logfmt\">logfmt</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/circuitbreaker\">circuitbreaker</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/offline_push\">offline_push</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/idgenerator\">idgenerator</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/gorm\">gorm</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/springdb\">springdb</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/mysql-driver\">mysql-driver</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/nsq_consumer\">nsq_consumer</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/redis\">redis</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/net2\">net2</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/retry\">retry</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/bytedancer\">bytedancer</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/igener\">igener</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/tokenbucket\">tokenbucket</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/aes\">aes</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/alarm\">alarm</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/access_state_machine\">access_state_machine</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/strategy\">strategy</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/asyncache\">asyncache</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/kafkasender\">kafkasender</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/diskq\">diskq</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/workpool\">workpool</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/inmem\">inmem</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/dbutil\">dbutil</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/addrhelp\">addrhelp</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/etcd_util\">etcd_util</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/ttlcache\">ttlcache</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/gencache\">gencache</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/memcache\">memcache</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/nsq\">nsq</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/redigo\">redigo</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/confhub\">confhub</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/context\">context</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/logs\">logs</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/scribe\">scribe</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/stats\">stats</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/snappy\">snappy</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/thrift\">thrift</a></li>\n" +
                "<li><a href=\"https://code.byted.org/gopkg/metrics\">metrics</a></li>";
        String[] splits = str.split("\n");
        Pattern p = Pattern.compile("https://code.byted.org/.*/.*\"");
        List<String> r = new ArrayList<>();
        List<String> w = new ArrayList<>();
        for (String split : splits) {
            Matcher matcher = p.matcher(split);
            if (matcher.find()) {
                String group = matcher.group();
                CharSequence sub = group.subSequence(0, group.length() - 1);
                r.add((String) sub);
            } else {
                w.add(split);
            }
        }
        System.out.println("total line number : " + splits.length);
        System.out.println("right:");
        for (String s : r) {
            System.out.println(s);
        }
        System.out.println("length : " + r.size());
        System.out.println("wrong:");
        for (String s : w) {
            System.out.println(s);
        }
        System.out.println("length : " + w.size());
        if (w.size() > 0 || splits.length != r.size()) {
            throw new RuntimeException("cuole");
        }
        return r;
    }

    public static class StreamGobbler extends Thread {

        InputStream is;
        String type;

        public StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    if (type.equals("Error")) {
                        System.out.println("Error   :" + line);
                    } else {
                        System.out.println("Output:" + line);
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * 参数 cmd 为Linux命令。每次只能执行一条命令。
     * 1.Java Runtime.exec()注意事项
     * 永远要在调用waitFor()方法之前读取数据流
     * 永远要先从标准错误流中读取，然后再读取标准输出流
     * 2.最好的执行系统命令的方法就是写个bat文件或是shell脚本。
     *
     * @param cmd
     */
    private static void shell(String cmd) {
        String[] cmds = {"/bin/sh", "-c", cmd};
        Process process;

        try {
            process = Runtime.getRuntime().exec(cmds);

            StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "Error");
            StreamGobbler outputGobbler = new StreamGobbler(process.getInputStream(), "Output");
            errorGobbler.start();
            outputGobbler.start();

            process.waitFor();

            errorGobbler.join();
            outputGobbler.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
