package regex.task_2;

/*
 * Given a string containing the following text (xml document).
 * Write an analyzer that allows you to sequentially return the contents of the
 * nodes of an xml document and its type (opening tag, closing tag, tag content, tag without body).
 * You cannot use ready-made XML parsers to solve this problem.
 */

public class Task2 {
    private static final String xml = """
            <notes>
                <note id = "1">
                    <to>Vasilij</to>
                    <from>Svetlana</from>
                    <heading>Reminder</heading>
                    <body>Call me tomorrow!</body>
                </note>
                <note id = "2">
                    <to>Petr</to>
                    <from>Mariya</from>
                    <heading>Important reminder!</heading>
                    <body/>
                </note>
            </notes>
            """;

    public static void main(String[] args) {
        Notes notes = new Notes(xml);
        System.out.print(notes);
    }
}