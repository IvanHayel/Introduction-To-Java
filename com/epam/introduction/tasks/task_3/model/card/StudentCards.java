package com.epam.introduction.tasks.task_3.model.card;

import com.epam.introduction.tasks.task_2.util.viewer.PageViewer;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "student-cards")
public class StudentCards implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private List<StudentCard> cardList;

    public StudentCards() {
        cardList = new ArrayList<>();
    }

    public List<StudentCard> getCardList() {
        return cardList;
    }

    @XmlElement(name = "student-card")
    public void setCardList(List<StudentCard> cardList) {
        this.cardList = cardList;
    }

    public void addCard(StudentCard card) {
        cardList.add(card);
    }

    public void showCardList() {
        PageViewer.pageDisplay(cardList);
    }

    public boolean isExist(long cardNumber) {
        for (StudentCard studentCard : cardList) {
            if (studentCard.getCardNumber() == cardNumber) {
                return true;
            }
        }
        return false;
    }

    public void remove(long cardNumber) {
        for (StudentCard studentCard : cardList) {
            if (cardNumber == studentCard.getCardNumber()) {
                cardList.remove(studentCard);
                break;
            }
        }
    }
}