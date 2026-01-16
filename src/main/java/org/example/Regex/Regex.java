package org.example.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    /**
     * გაუშვით main მეთოდი თქვენი კოდის დასატესტად. თუ ქართული ასოების შეცდომა გამოვა, სცადეთ ხელახლა სანამ არ გასწორდება.
     */
    public static void main(String[] args) {

        List<String> numbers = matchNumbers("abcd123efgh4567");
        assert numbers.size() == 2;
        assert numbers.get(0).equals("123");
        assert numbers.get(1).equals("4567");

        List<String> chars = matchCharsWithVowels("abcd123efghi45jklm67");
        assert chars.size() == 2;
        assert chars.get(0).equals("abcd");
        assert chars.get(1).equals("efgh");

        assert matchIp("127.0.0.10");
        assert matchIp("192.168.0.255");
        assert !matchIp("192.168.0.256");
        assert !matchIp("300.168.0.256");
        assert !matchIp("192.168.0.255.1");

        assert matchEmail("saba.zedginidze@mziuri.ge");
        assert !matchEmail("saba.zedginidze@mziuri");
        assert !matchEmail("saba.zedg.inidze@mziuri.ge");
        assert !matchEmail("saba.2003@mziuri.ge");

        assert matchPhone("+995 555-123-456");
        assert !matchPhone("+995 555-123-4567");
        assert !matchPhone("+995 555-1234-456");
        assert !matchPhone("555-123-456-789");

    }

    /**
     * დაწერეთ regex რომელიც დააბრუნებს მხოლოდ გადაცემული string-ში მიმდევრობით არსებულ ციფრებს
     */
    private static List<String> matchNumbers(String s) {
        List<String> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            numbers.add(matcher.group());
        }
        return numbers;
    }

    /**
     * დაწერეთ regex რომელიც დააბრუნებს ისეთ ასოების მიმდევრობებს, რომელიც იწყება ხმოვნებით
     */
    private static List<String> matchCharsWithVowels(String s) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            String group = matcher.group();
            if (group.matches(".*[aeiouAEIOU].*")) {
                result.add(group);
            }
        }
        return result;
    }

    /**
     * დაწერეთ regex რომელიც დაბეჭდავს true/false-ს - არის თუ არა მოცემული string ვალიდური ip მისამართი (ფორმატი: x.x.x.x, სადაც 0 <= x <= 255)
     */
    private static boolean matchIp(String s) {
        Pattern ipPattern = Pattern.compile("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$");
        return ipPattern.matcher(s).matches();
    }

    /**
     * დაწერეთ იმეილის regex შემდეგი ფორმატით: saxeli.gvari@mziuri.ge
     */
    private static boolean matchEmail(String s) {
        Pattern emailPattern = Pattern.compile("^[a-zA-Z]+\\.[a-zA-Z]+@mziuri\\.ge$");
        return emailPattern.matcher(s).matches();
    }

    /**
     * დაწერეთ ტელეფონის ნომერის რეგექსი ფორმატით: +995 5xx-xxx-xxx, სადაც 0 <= x <= 9
     */
    private static boolean matchPhone(String s) {
        Pattern phonePattern = Pattern.compile("^\\+995 5\\d{2}-\\d{3}-\\d{3}$");
        return phonePattern.matcher(s).matches();
    }

}