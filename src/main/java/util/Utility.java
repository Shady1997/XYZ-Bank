package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class Utility {

    public static void replaceLinesInExtendReportHtmlFile(String filePath) throws IOException {
        // Read the HTML file into a list of strings (each string is a line)
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Define the new content for the specific lines
        String line25 = "<style>\n" +
                "    .goog-te-gadget-simple{\n" +
                "    display:flex !important;\n" +
                "    width:100% !important;\n" +
                "    height:40px !important;\n" +
                "    }\n" +
                "    .goog-te-gadget-icon{\n" +
                "    padding-bottom:10px !important;\n" +
                "    }\n" +
                "    .goog-te-gadget-simple span{\n" +
                "    padding-top:15px !important;\n" +
                "    }\n" +
                "    .VIpgJd-ZVi9od-xl07Ob-lTBxed{\n" +
                "    height:20px!important;\n" +
                "    }\n";

        String line31 = "</style>\n" +
                "<script type=\"text/javascript\">// <![CDATA[\n" +
                "function googleTranslateElementInit() {\n" +
//                "    new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE,includedLanguages: 'az,br,de,en,ar,es,fr,he,isv,ja,ka,kr,nl,pl,ru,sv,tr,zh-CN'}, 'google_translate_element');\n" +
                "    new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');\n" +
                "}\n" +
                "// ]]></script>\n" +
                "<script src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\" type=\"text/javascript\"></script>";

        String line67 = "<div id=\"google_translate_element\" style=\"float:right;height: 43px!important;width: 150px;\"></div>";

        // Replace specific lines
        lines.set(24, line25); // Line 25 (index 24 in zero-indexed list)
        lines.set(30, line31); // Line 31 (index 30 in zero-indexed list)
        lines.set(66, line67); // Line 67 (index 66 in zero-indexed list)

        // Write the updated content back to the file
        Files.write(Paths.get(filePath), lines);
    }

    public static void replaceLinesInAllureReportHtmlFile(String filePath) throws IOException {
        // Read the HTML file into a list of strings (each string is a line)
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Define the new content for the specific lines
        String line5 = "<title>Allure Report</title><div id=\"google_translate_element\" style=\"float:right; height: 43px !important; width: auto !important;\"></div>\n" +
                "\n" +
                "<style>\n" +
                "    .goog-te-gadget-simple {\n" +
                "        display: flex !important;\n" +
                "        justify-content: flex-end !important; /* Align content to the right */\n" +
                "        width: 100% !important;\n" +
                "        height: 40px !important;\n" +
                "        align-items: center !important; /* Vertically center the content */\n" +
                "    }\n" +
                "    .goog-te-gadget-icon {\n" +
                "        padding-bottom: 10px !important;\n" +
                "    }\n" +
                "    .goog-te-gadget-simple span {\n" +
                "        padding-top: 15px !important;\n" +
                "    }\n" +
                "    .VIpgJd-ZVi9od-xl07Ob-lTBxed {\n" +
                "        height: 20px !important;\n" +
                "    }\n" +
                "</style>\n" +
                "\n" +
                "<script type=\"text/javascript\">// <![CDATA[\n" +
                "function googleTranslateElementInit() {\n" +
                "    new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');\n" +
                "}\n" +
                "// ]]></script>\n" +
                "\n" +
                "<script src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\" type=\"text/javascript\"></script>\n";

        // Replace specific lines
        lines.set(4, line5); // Line 5 (index 4 in zero-indexed list)

        // Write the updated content back to the file
        Files.write(Paths.get(filePath), lines);
    }

    public static void copyFileToParent(String childFilePath) {
        try {
            // Create Path object for the child file
            Path childPath = Paths.get(childFilePath);

            // Get the parent directory of the child file
            Path parentPath = childPath.getParent().getParent();

            // Construct the destination path in the parent folder
            Path destinationPath = parentPath.resolve(childPath.getFileName());

            // Copy the file to the parent folder
            Files.copy(childPath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File copied successfully to: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            replaceLinesInExtendReportHtmlFile("C:\\Users\\g525585\\Downloads\\OS\\XYZ-Bank\\index.html");
            replaceLinesInAllureReportHtmlFile("C:\\Users\\g525585\\Downloads\\OS\\XYZ-Bank\\allure-report\\index.html");
            System.out.println("HTML file updated successfully.");

            // Example usage: Provide the path of the file inside a child folder
            String childFilePath = "child_folder/myfile.txt";
            copyFileToParent(childFilePath);
        } catch (IOException e) {
            System.err.println("Error updating HTML file: " + e.getMessage());
        }
    }
}
