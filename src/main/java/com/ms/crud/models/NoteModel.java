package com.ms.crud.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "note")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class NoteModel {
    private static final long serialVersionUID = 3303958233860785745L;

    @Id
    @Column(name = "NOTE_ID")
    @SequenceGenerator(name = "note_seq", sequenceName = "note_app.note_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_seq")
    private Integer noteId;


    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NoteModel noteModel = (NoteModel) o;
        return noteId != null && Objects.equals(noteId, noteModel.noteId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
