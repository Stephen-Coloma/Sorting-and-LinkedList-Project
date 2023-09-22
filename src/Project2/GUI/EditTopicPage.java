package Project2.GUI;
import Project2.ReferenceClasses.Topic;
import javax.swing.*;
import java.awt.*;

public class EditTopicPage {
    private JTextField moduleField, taskField;
    private JButton updateButton;
    private JPanel editTopicPanel, buttonPanel;

    public EditTopicPage(DefaultListModel<Topic> topicDefaultListModel, Topic selectedTopic, int selectedIndex) {

        setTitle("Edit Topic");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
