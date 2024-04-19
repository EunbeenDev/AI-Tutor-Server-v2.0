package com.example.ai_tutor.domain.tutor.domain;

import com.example.ai_tutor.domain.Folder.domain.Folder;
import com.example.ai_tutor.domain.common.BaseEntity;
import com.example.ai_tutor.domain.note.domain.Note;
import com.example.ai_tutor.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Tutor")
@NoArgsConstructor
@Getter
public class Tutor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tutor_id", updatable = false, nullable = false)
    private Long tutorId;

    @Column(name="question")
    private String question;

    @Column(name = "user_answer")
    private String userAnswer;

    @Column(name = "ai_answer")
    private String aiAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="folder_id")
    private Folder folder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="note_id")
    private Note note;


    @Builder
    public Tutor(User user, Folder folder, Note note, String question, String userAnswer, String aiAnswer){
        this.user = user;
        this.folder = folder;
        this.note = note;
        this.question = question;
        this.userAnswer = userAnswer;
        this.aiAnswer = aiAnswer;
    }
}