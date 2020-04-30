package com.bridgelabz.fundoonotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int noteId;

    private String title;

    private String description;

    private String color;

    private boolean isPinned;

    private boolean isArchived;

    private boolean isTrashed;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private String reminder;

    private String repeatReminder;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    //@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "note_label")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Label> labels;



    @javax.persistence.Id
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public boolean isTrashed() {
        return isTrashed;
    }

    public void setTrashed(boolean trashed) {
        isTrashed = trashed;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean addLabel(Label label) {
        if (labels == null)
            labels = new HashSet<>();
        return labels.add(label);
    }

    public boolean removeLabel(Label label) {
        return labels.remove(label);
    }
    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public String getRepeatReminder() {
        return repeatReminder;
    }

    public void setRepeatReminder(String repeatReminder) {
        this.repeatReminder = repeatReminder;
    }

    public Note() {
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", isPinned=" + isPinned +
                ", isArchived=" + isArchived +
                ", isTrashed=" + isTrashed +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", reminder='" + reminder + '\'' +
                ", repeatReminder='" + repeatReminder + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Note) {
            Note note = (Note) obj;
            if (this.title.equals(note.title) && this.description.equals(note.description))
                return true;
            else
                return false;
        }
        throw new IllegalArgumentException("Cannot compare objects that are not of Notes");
    }
    @Override
    public int hashCode() {
        return Objects.hash(getNoteId(), getTitle(), getDescription(), getColor(), isPinned(), isArchived(), isTrashed(), getCreatedDate(), getModifiedDate(), getReminder(), getRepeatReminder());
    }
}
