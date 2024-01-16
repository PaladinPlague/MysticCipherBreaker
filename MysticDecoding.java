import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MysticDecoding extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    // IF YOU ARE SEEING THIS PROJECT PLEASE DON'T JUDGE THAT IS 5000000 IFS, THIS
    // WAS JUST A JOKE PROJECT TO MESS WITH A FRIEND WHO SAID IT COULDN'T BE DONE.
    // ITS ON MY GITHUB CAUSE I LIKE TO KEEP MY CODE HERE

    // This program is to decrypt codes given to Mystic, BUT SHOULD NOT BE GIVEN FOR
    // USE IN OPS!

    // Link to Cypher Codex:
    // https://docs.google.com/document/d/1sn5tqn7Hgt5fn4bNiOZjKVX3UTn2NQ8C5CVdmYG3yUQ/edit?usp=sharing

    public MysticDecoding() {
        // Set up the frame
        super("Message Unscrambler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        // Create input and output text areas
        inputTextArea = new JTextArea("Enter scrambled message here", 10, 30);
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);

        // Saber
        JButton SaberButton = new JButton("Unscramble Saber Cypher");
        SaberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unscrambleSaber();
            }
        });

        // Sentry
        JButton SentryButton = new JButton("Unscramble Sentry Cypher");
        SentryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unscrambleSentry();
            }
        });

        // Eclipse
        JButton EclipseButton = new JButton("Unscramble Eclipse Cypher");
        EclipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unscrambleEclipse();
            }
        });

        // Orion
        JButton OrionButton = new JButton("Unscramble Orion Cypher (Use '-' for each new letter)");
        OrionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unscrambleOrion();
            }
        });

        // Plasma
        JButton PlasmaButton = new JButton("Unscramble Plasma Cypher (Use '-' for each new letter & _ for spaces)");
        PlasmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unscramblePlasma();
            }
        });

        // Kyber
        JButton KyberButton = new JButton("Unscramble Kyber Cypher (Use '-' for each new letter/coordinate");
        KyberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unscrambleKyber();
            }
        });

        // Beskar
        JButton BeskarButton = new JButton("Unscramble Beskar Cypher (Use ' ' for each new letter/coordinate");
        BeskarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unscrambleBeskar();
            }
        });

        // Create a layout and add components
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JScrollPane(inputTextArea));
        add(SaberButton);
        add(SentryButton);
        add(EclipseButton);
        add(OrionButton);
        add(PlasmaButton);
        add(KyberButton);
        add(BeskarButton);
        add(new JScrollPane(outputTextArea));

        // Show the frame
        setVisible(true);
    }

    private void unscrambleSaber() {
        String inputText = inputTextArea.getText();
        String unscrambledText = unscrambleSaberMethod(inputText);
        outputTextArea.setText(unscrambledText);
    }

    // 15 13 27 6 2 25 12 27 2 7 19 7 27 13 7 27 11 24 27 15 11 15 25 20 = AW SHIT
    // HERE WE GO AGAIN
    private String unscrambleSaberMethod(String input) {
        List<Character> Chars = new ArrayList<>();
        String[] strList = input.split(" ");
        List<Character> Cypher = new ArrayList<>(Arrays.asList('B', 'H', 'M', 'Q', 'K', 'S', 'E', 'C', 'L', 'P', 'G',
                'T', 'W', 'Y', 'A', 'Z', 'X', 'J', 'R', 'N', 'U', 'D', 'V', 'O', 'I', 'F', ' '));

        for (int i = 0; i < strList.length; i++) {
            Chars.add(Cypher.get(Integer.parseInt(strList[i]) - 1));

        }
        StringBuilder string = new StringBuilder();
        for (Character ch : Chars) {
            string.append(ch);
        }
        String FinalOutput = string.toString();
        return FinalOutput;
    }

    private void unscrambleSentry() {
        String inputText = inputTextArea.getText();
        List<String> unscrambledText = unscrambleSentryMethod(inputText);
        Collections.sort(unscrambledText);
        String listString = String.join(", \n", unscrambledText);
        outputTextArea.setText(listString);
    }

    // 1 4 2 8 6 7 will contain "NICKEX"
    private List<String> unscrambleSentryMethod(String input) {
        List<String> Words = new ArrayList<>();
        String[] strList = input.split(" ");
        List<String> Cypher = new ArrayList<>(Arrays.asList("A|N", "C|V", "J|U", "I|Q", "F|W", "E|T", "H|X", "K|P",
                "D|S", "L|R", "G|O", "M|Z", "B|Y", " | "));
        for (int i = 0; i < strList.length; i++) {
            String[] temp = Cypher.get(Integer.parseInt(strList[i]) - 1).split("|");
            if (Words.size() != 0) {
                Words.addAll(Words);
                for (int j = 0; j < Words.size() / 2; j++) {
                    Words.set(j, Words.get(j) + temp[0]);
                }
                for (int j = Words.size() / 2; j < Words.size(); j++) {
                    Words.set(j, Words.get(j) + temp[2]);
                }
            } else {
                Words.add(temp[0]);
                Words.add(temp[2]);
            }
        }
        return Words;
    }

    private void unscrambleEclipse() {
        String inputText = inputTextArea.getText();
        List<String> unscrambledText = unscrambleEclipseMethod(inputText);
        Collections.sort(unscrambledText);
        String listString = String.join(", \n", unscrambledText);
        outputTextArea.setText(listString);
    }

    // 6 1 5 12 6 2 will contain "MYSTIC"
    private List<String> unscrambleEclipseMethod(String input) {
        List<String> Words = new ArrayList<>();
        String[] strList = input.split(" ");
        List<String> Cypher = new ArrayList<>(Arrays.asList("Q|Y", "K|U|C", "D|N", "B", "S", "E|I|M", "G", "L", "R|F",
                "W", "Z", "T|H", "V|J", "P", "X", "O|A", " "));
        for (int i = 0; i < strList.length; i++) {
            String[] temp = Cypher.get(Integer.parseInt(strList[i]) - 1).split("|");
            if (Words.size() != 0) {
                if (temp.length == 1) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + temp[0]);
                    }
                } else if (temp.length == 3) {
                    Words.addAll(Words);
                    for (int j = 0; j < Words.size() / 2; j++) {
                        Words.set(j, Words.get(j) + temp[0]);
                    }
                    for (int j = Words.size() / 2; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + temp[2]);
                    }
                } else if (temp.length == 5) {
                    List<String> WordsDuper = new ArrayList<>();
                    WordsDuper.addAll(Words);
                    Words.addAll(WordsDuper);
                    Words.addAll(WordsDuper);
                    for (int j = 0; j < Words.size() / 3; j++) {
                        Words.set(j, Words.get(j) + temp[0]);
                    }
                    for (int j = Words.size() / 3; j < (Words.size() / 3) * 2; j++) {
                        Words.set(j, Words.get(j) + temp[2]);
                    }
                    for (int j = (Words.size() / 3) * 2; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + temp[4]);
                    }
                }
            } else {
                if (temp.length == 1) {
                    Words.add(temp[0]);
                } else if (temp.length == 3) {
                    Words.add(temp[0]);
                    Words.add(temp[2]);
                } else if (temp.length == 5) {
                    Words.add(temp[0]);
                    Words.add(temp[2]);
                    Words.add(temp[4]);
                }
            }
        }
        return Words;
    }

    private void unscrambleOrion() {
        String inputText = inputTextArea.getText();
        List<String> unscrambledText = unscrambleOrionMethod(inputText);
        Collections.sort(unscrambledText);
        String listString = String.join(", \n", unscrambledText);
        outputTextArea.setText(listString);
    }

    // 4-..-3-... . ...-7-..-9-4-... ... Will contain "Endsinger"
    private List<String> unscrambleOrionMethod(String input) {
        List<String> Words = new ArrayList<>();
        String[] strList = input.split("-");
        List<String> Cypher = new ArrayList<>(
                Arrays.asList("A|V", "B|W", "D|C", "E|X", "F|J", "H|Y", "I|Z", "J|K", "L|G"));
        for (int i = 0; i < strList.length; i++) {
            if (Words.size() != 0) {
                if (strList[i].matches("1") || strList[i].matches("2") || strList[i].matches("3")
                        || strList[i].matches("4") || strList[i].matches("5") || strList[i].matches("6")
                        || strList[i].matches("7") || strList[i].matches("8") || strList[i].matches("9")) {
                    String[] temp = Cypher.get(Integer.parseInt(strList[i]) - 1).split("|");
                    Words.addAll(Words);
                    for (int j = 0; j < Words.size() / 2; j++) {
                        Words.set(j, Words.get(j) + temp[0]);
                    }
                    for (int j = Words.size() / 2; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + temp[2]);
                    }

                } else {
                    if (strList[i].matches(".")) {
                        for (int j = 0; j < Words.size(); j++) {
                            Words.set(j, Words.get(j) + "M");
                        }
                    } else if (strList[i].matches("..")) {
                        Words.addAll(Words);
                        for (int j = 0; j < Words.size() / 2; j++) {
                            Words.set(j, Words.get(j) + "N");
                        }
                        for (int j = Words.size() / 2; j < Words.size(); j++) {
                            Words.set(j, Words.get(j) + "V");
                        }
                    } else if (strList[i].matches("...")) {
                        for (int j = 0; j < Words.size(); j++) {
                            Words.set(j, Words.get(j) + "O");
                        }
                    } else if (strList[i].matches(".. ..")) {
                        for (int j = 0; j < Words.size(); j++) {
                            Words.set(j, Words.get(j) + "P");
                        }
                    } else if (strList[i].matches("... ..")) {
                        for (int j = 0; j < Words.size(); j++) {
                            Words.set(j, Words.get(j) + "Q");
                        }
                    } else if (strList[i].matches("... ...")) {
                        for (int j = 0; j < Words.size(); j++) {
                            Words.set(j, Words.get(j) + "R");
                        }
                    } else if (strList[i].matches("... . ...")) {
                        for (int j = 0; j < Words.size(); j++) {
                            Words.set(j, Words.get(j) + "S");
                        }
                    } else if (strList[i].matches(".... ....")) {
                        for (int j = 0; j < Words.size(); j++) {
                            Words.set(j, Words.get(j) + "T");
                        }
                    } else if (strList[i].matches("... ......")) {
                        for (int j = 0; j < Words.size(); j++) {
                            Words.set(j, Words.get(j) + "U");
                        }
                    } else if (strList[i].matches("-")) {
                        for (int j = 0; j < Words.size(); j++) {
                            Words.set(j, Words.get(j) + " ");
                        }
                    }

                }
            } else {

                if (strList[i].matches("1") || strList[i].matches("2") || strList[i].matches("3")
                        || strList[i].matches("4") || strList[i].matches("5") || strList[i].matches("6")
                        || strList[i].matches("7") || strList[i].matches("8") || strList[i].matches("9")) {
                    String[] temp = Cypher.get(Integer.parseInt(strList[i]) - 1).split("|");

                    Words.add(temp[0]);
                    Words.add(temp[2]);
                } else {
                    if (strList[i].matches(".")) {
                        Words.add("M");
                    } else if (strList[i].matches("..")) {
                        Words.add("N");
                        Words.add("V");
                    } else if (strList[i].matches("...")) {
                        Words.add("O");
                    } else if (strList[i].matches(".. ..")) {
                        Words.add("P");
                    } else if (strList[i].matches("... ..")) {
                        Words.add("Q");
                    } else if (strList[i].matches("... ...")) {
                        Words.add("R");
                    } else if (strList[i].matches("... . ...")) {
                        Words.add("S");
                    } else if (strList[i].matches(".... ....")) {
                        Words.add("T");
                    } else if (strList[i].matches("... ......")) {
                        Words.add("U");
                    }

                }
            }
        }
        return Words;
    }

    private void unscramblePlasma() {
        String inputText = inputTextArea.getText();
        List<String> unscrambledText = unscramblePlasmaMethod(inputText);
        Collections.sort(unscrambledText);
        String listString = String.join(", \n", unscrambledText);
        outputTextArea.setText(listString);
    }

    // ...-... . ...-...... . ......-...... . ......-.... .... ....-.... .... ....-.
    // . .-... . . .-...-.... ...-. . . Will contain "COFFEESUCKS"
    private List<String> unscramblePlasmaMethod(String input) {
        List<String> Words = new ArrayList<>();
        String[] strList = input.split("-");
        for (int i = 0; i < strList.length; i++) {
            if (Words.size() != 0) {
                if (strList[i].matches(".")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "A");
                    }
                } else if (strList[i].matches("..")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "B");
                    }
                } else if (strList[i].matches("...")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "C");
                    }
                } else if (strList[i].matches(".. ..")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "M");
                    }
                } else if (strList[i].matches("... ..")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "Q");
                    }
                } else if (strList[i].matches(".... ...")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "K");
                    }
                } else if (strList[i].matches("... . . .")) {
                    Words.addAll(Words);
                    for (int j = 0; j < Words.size() / 2; j++) {
                        Words.set(j, Words.get(j) + "U");
                    }
                    for (int j = Words.size() / 2; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "V");
                    }
                } else if (strList[i].matches("... . ...")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "O");
                    }
                } else if (strList[i].matches(".... ....")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "P");
                    }
                } else if (strList[i].matches("......... .. .")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "L");
                    }
                } else if (strList[i].matches(". . .")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "S");
                    }
                } else if (strList[i].matches(".. .. ..")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "D");
                    }
                } else if (strList[i].matches("... ... ...")) {
                    Words.addAll(Words);
                    for (int j = 0; j < Words.size() / 2; j++) {
                        Words.set(j, Words.get(j) + "R");
                    }
                    for (int j = Words.size() / 2; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "H");
                    }
                } else if (strList[i].matches(".... .... ....")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "E");
                    }
                } else if (strList[i].matches("..... ..")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "I");
                    }
                } else if (strList[i].matches("... ...")) {
                    Words.addAll(Words);
                    for (int j = 0; j < Words.size() / 2; j++) {
                        Words.set(j, Words.get(j) + "T");
                    }
                    for (int j = Words.size() / 2; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "G");
                    }
                } else if (strList[i].matches("... .. ...")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "N");
                    }
                } else if (strList[i].matches("...... . ......")) {
                    Words.addAll(Words);
                    for (int j = 0; j < Words.size() / 2; j++) {
                        Words.set(j, Words.get(j) + "F");
                    }
                    for (int j = Words.size() / 2; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "W");
                    }
                } else if (strList[i].matches("..... .... .....")) {
                    Words.addAll(Words);
                    for (int j = 0; j < Words.size() / 2; j++) {
                        Words.set(j, Words.get(j) + "J");
                    }
                    for (int j = Words.size() / 2; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "Y");
                    }
                } else if (strList[i].matches("... .. ..")) {
                    Words.addAll(Words);
                    for (int j = 0; j < Words.size() / 2; j++) {
                        Words.set(j, Words.get(j) + "X");
                    }
                    for (int j = Words.size() / 2; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + "Z");
                    }
                } else if (strList[i].matches("_")) {
                    for (int j = 0; j < Words.size(); j++) {
                        Words.set(j, Words.get(j) + " ");
                    }
                }

            } else {
                if (strList[i].matches(".")) {
                    Words.add("A");
                } else if (strList[i].matches("..")) {
                    Words.add("B");
                } else if (strList[i].matches("...")) {
                    Words.add("C");
                } else if (strList[i].matches(".. ..")) {
                    Words.add("M");
                } else if (strList[i].matches("... ..")) {
                    Words.add("Q");
                } else if (strList[i].matches(".... ...")) {
                    Words.add("K");
                } else if (strList[i].matches("... . ...")) {
                    Words.add("O");
                } else if (strList[i].matches(".... ....")) {
                    Words.add("P");
                } else if (strList[i].matches("......... .. .")) {
                    Words.add("L");
                } else if (strList[i].matches(". . .")) {
                    Words.add("S");
                } else if (strList[i].matches(".. .. ..")) {
                    Words.add("D");
                } else if (strList[i].matches("... ... ...")) {
                    Words.add("R");
                    Words.add("H");
                } else if (strList[i].matches(".... .... ....")) {
                    Words.add("E");
                } else if (strList[i].matches("..... ..")) {
                    Words.add("I");
                } else if (strList[i].matches("... ...")) {
                    Words.add("T");
                    Words.add("G");
                } else if (strList[i].matches("... .. ...")) {
                    Words.add("N");
                } else if (strList[i].matches("...... . ......")) {
                    Words.add("F");
                    Words.add("W");
                } else if (strList[i].matches("..... .... .....")) {
                    Words.add("J");
                    Words.add("Y");
                } else if (strList[i].matches("... .. ..")) {
                    Words.add("X");
                    Words.add("Z");
                } else if (strList[i].matches("... . . .")) {
                    Words.add("U");
                    Words.add("V");
                } else if (strList[i].matches("_")) {
                    Words.add(" ");
                }

            }
        }
        return Words;
    }

    private void unscrambleKyber() {
        String inputText = inputTextArea.getText();
        String unscrambledText = unscrambleKyberMethod(inputText);
        outputTextArea.setText(unscrambledText);
    }

    // 12,2-26,7-10,9-10,9-7,10-2,1-7,10-16,2 will be "ROLLAWAY"
    private String unscrambleKyberMethod(String input) {
        String Word = "";
        String[] strList = input.split("-");
        char[][] CharMatrix = {
                { 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B',
                        'H', 'D', 'N', 'I', 'P', 'Q' },
                { 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H',
                        'D', 'N', 'I', 'P', 'Q', 'C' },
                { 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D',
                        'N', 'I', 'P', 'Q', 'C', 'W' },
                { 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N',
                        'I', 'P', 'Q', 'C', 'W', 'F' },
                { 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I',
                        'P', 'Q', 'C', 'W', 'F', 'S' },
                { 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P',
                        'Q', 'C', 'W', 'F', 'S', 'G' },
                { 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q',
                        'C', 'W', 'F', 'S', 'G', 'O' },
                { 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C',
                        'W', 'F', 'S', 'G', 'O', 'Z' },
                { 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W',
                        'F', 'S', 'G', 'O', 'Z', 'T' },
                { 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F',
                        'S', 'G', 'O', 'Z', 'T', 'K' },
                { 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S',
                        'G', 'O', 'Z', 'T', 'K', 'E' },
                { 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G',
                        'O', 'Z', 'T', 'K', 'E', 'M' },
                { 'R', 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O',
                        'Z', 'T', 'K', 'E', 'M', 'U' },
                { 'X', 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z',
                        'T', 'K', 'E', 'M', 'U', 'R' },
                { 'J', 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T',
                        'K', 'E', 'M', 'U', 'R', 'X' },
                { 'A', 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K',
                        'E', 'M', 'U', 'R', 'X', 'J' },
                { 'Y', 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E',
                        'M', 'U', 'R', 'X', 'J', 'A' },
                { 'L', 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M',
                        'U', 'R', 'X', 'J', 'A', 'Y' },
                { 'V', 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U',
                        'R', 'X', 'J', 'A', 'Y', 'L' },
                { 'B', 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R',
                        'X', 'J', 'A', 'Y', 'L', 'V' },
                { 'H', 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X',
                        'J', 'A', 'Y', 'L', 'V', 'B' },
                { 'D', 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J',
                        'A', 'Y', 'L', 'V', 'B', 'H' },
                { 'N', 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A',
                        'Y', 'L', 'V', 'B', 'H', 'D' },
                { 'I', 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y',
                        'L', 'V', 'B', 'H', 'D', 'N' },
                { 'P', 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L',
                        'V', 'B', 'H', 'D', 'N', 'I' },
                { 'Q', 'C', 'W', 'F', 'S', 'G', 'O', 'Z', 'T', 'K', 'E', 'M', 'U', 'R', 'X', 'J', 'A', 'Y', 'L', 'V',
                        'B', 'H', 'D', 'N', 'I', 'P' } };
        for (int i = 0; i < strList.length; i++) {
            String[] coord = strList[i].split(",");
            Word = Word + CharMatrix[Integer.parseInt(coord[0]) - 1][Integer.parseInt(coord[1]) - 1];
            coord = null;

        }
        return Word;
    }

    private void unscrambleBeskar() {
        String inputText = inputTextArea.getText();
        String unscrambledText = unscrambleBeskarMethod(inputText);
        outputTextArea.setText(unscrambledText);
    }

    // 12,2-26,7-10,9-10,9-7,10-2,1-7,10-16,2 will be "ROLLAWAY"
    private String unscrambleBeskarMethod(String input) {
        String Word = "";
        String[] strList = input.split(" ");
        int[][] CharMatrix = {
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 },
                { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1 },
                { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2 },
                { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3 },
                { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4 },
                { 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5 },
                { 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6 },
                { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7 },
                { 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8 },
                { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                { 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 },
                { 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 },
                { 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 },
                { 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 },
                { 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
                { 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 },
                { 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 },
                { 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 },
                { 20, 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 },
                { 21, 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
                { 22, 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 },
                { 23, 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 },
                { 24, 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 },
                { 25, 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 },
                { 26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 }, };
        for (int i = 0; i < strList.length; i++) {
            if (i > 0 && i != strList.length) {
                Word = Word + ",";
            }
            String[] coord = strList[i].split(",");
            ArrayList<Integer> Val = new ArrayList<Integer>();
            Val = matchCoord(coord);
            Word = Word + CharMatrix[Val.get(0)][Val.get(1)];

        }
        return Word;
    }

    private ArrayList<Integer> matchCoord(String[] Value) {
        ArrayList<Integer> coordinate = new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            if (Value[i].matches("A")) {
                coordinate.add(0);
            } else if (Value[i].matches("B")) {
                coordinate.add(1);
            } else if (Value[i].matches("C")) {
                coordinate.add(2);
            } else if (Value[i].matches("D")) {
                coordinate.add(3);
            } else if (Value[i].matches("E")) {
                coordinate.add(4);
            } else if (Value[i].matches("F")) {
                coordinate.add(5);
            } else if (Value[i].matches("G")) {
                coordinate.add(6);
            } else if (Value[i].matches("H")) {
                coordinate.add(7);
            } else if (Value[i].matches("I")) {
                coordinate.add(8);
            } else if (Value[i].matches("J")) {
                coordinate.add(9);
            } else if (Value[i].matches("K")) {
                coordinate.add(10);
            } else if (Value[i].matches("L")) {
                coordinate.add(11);
            } else if (Value[i].matches("M")) {
                coordinate.add(12);
            } else if (Value[i].matches("N")) {
                coordinate.add(13);
            } else if (Value[i].matches("O")) {
                coordinate.add(14);
            } else if (Value[i].matches("P")) {
                coordinate.add(15);
            } else if (Value[i].matches("Q")) {
                coordinate.add(16);
            } else if (Value[i].matches("R")) {
                coordinate.add(17);
            } else if (Value[i].matches("S")) {
                coordinate.add(18);
            } else if (Value[i].matches("T")) {
                coordinate.add(19);
            } else if (Value[i].matches("U")) {
                coordinate.add(20);
            } else if (Value[i].matches("V")) {
                coordinate.add(21);
            } else if (Value[i].matches("W")) {
                coordinate.add(22);
            } else if (Value[i].matches("X")) {
                coordinate.add(23);
            } else if (Value[i].matches("Y")) {
                coordinate.add(24);
            } else if (Value[i].matches("Z")) {
                coordinate.add(25);
            }
        }

        return coordinate;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MysticDecoding();
            }
        });
    }
}

/*
 * OLD AND TEDIOUS VERSION OF THE CODE FOR SABER THAT REQUIRED WAY TOO MUCH
 * MAINTENANCE
 * 
 * System.out.println(strList[0]);
 * System.out.println(strList[1]);
 * if(strList[i].equals("1")){
 * Chars.add('B');
 * }else if(strList[i].equals("2")){
 * Chars.add('H');
 * }else if(strList[i].equals("3")){
 * Chars.add('M');
 * }else if(strList[i].equals("4")){
 * Chars.add('Q');
 * }else if(strList[i].equals("5")){
 * Chars.add('K');
 * }else if(strList[i].equals("6")){
 * Chars.add('S');
 * }else if(strList[i].equals("7")){
 * Chars.add('E');
 * }else if(strList[i].equals("8")){
 * Chars.add('C');
 * }else if(strList[i].equals("9")){
 * Chars.add('L');
 * }else if(strList[i].equals("10")){
 * Chars.add('P');
 * }else if(strList[i].equals("11")){
 * Chars.add('G');
 * }else if(strList[i].equals("12")){
 * Chars.add('T');
 * }else if(strList[i].equals("13")){
 * Chars.add('W');
 * }else if(strList[i].equals("14")){
 * Chars.add('Y');
 * }else if(strList[i].equals("15")){
 * Chars.add('A');
 * }else if(strList[i].equals("16")){
 * Chars.add('Z');
 * }else if(strList[i].equals("17")){
 * Chars.add('X');
 * }else if(strList[i].equals("18")){
 * Chars.add('J');
 * }else if(strList[i].equals("19")){
 * Chars.add('R');
 * }else if(strList[i].equals("20")){
 * Chars.add('N');
 * }else if(strList[i].equals("21")){
 * Chars.add('U');
 * }else if(strList[i].equals("22")){
 * Chars.add('D');
 * }else if(strList[i].equals("23")){
 * Chars.add('V');
 * }else if(strList[i].equals("24")){
 * Chars.add('O');
 * }else if(strList[i].equals("25")){
 * Chars.add('I');
 * }else if(strList[i].equals("26")){
 * Chars.add('F');
 * }else if(strList[i].equals("_")){
 * Chars.add(' ');
 * }else{
 * return "Error in Processing, check the numbers are correct";
 * }
 */