package models;

import play.data.validation.Constraints;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by amd on 7/17/15.
 */
public class Post {
    private static List<Post> posts;
    public Integer id;
    @Constraints.MaxLength(120)
    @Constraints.Required
    public String title;
    public String description;
    public String category;
    public Integer supporters;
    public Integer opponents;
    public Integer likes;
    public Integer dislikes;
    public Date created_on;
    public String author;

    public Post(Integer id, String title, String description, String category, Integer supporters, Integer opponents, Integer likes, Integer dislikes, Date created_on, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.supporters = supporters;
        this.opponents = opponents;
        this.likes = likes;
        this.dislikes = dislikes;
        this.created_on = created_on;
        this.author = author;
        this.category = category;
    }

    public Post(String title, String description, String category, String author){
        this.title = title;
        this.description = description;
        this.supporters = 0;
        this.opponents = 0;
        this.likes = 0;
        this.dislikes = 0;
        this.created_on = new Date();
        this.author = author;
        this.category = category;
    }

    static{
        posts = new ArrayList<>();
        posts.add(
                new Post(1, "CBI to open office in Bhopal's haunted bungalow",
                        "it evokes fear among the officials and bureaucrats here. No one wants to be anywhere near this deserted building. It's bungalow B-10 at Professors Colony which is better known as the 'Bhoot Bungalow' in Bhopal. Over the years the precinct has got a bad name: untimely deaths of its occupant and other serious controversies led to dark tales of ghosts and myths about the bungalow, enough to scare even the bravest of souls around.\n" +
                                "But all of that has not deterred the Central Bureau of Investigation (CBI). The premier investigating agency has decided to open its office in the bungalow from where it will probe into the Vyapam scam. Located about 200 metres from the chief minister's residence, the bungalow has become known as a \"jinxed precinct\".",
                        "Political",13,6,32,5,new Date(),"Anonymus")
        );

        posts.add(
                new Post(2, "Stephen's molestation: Victim 'denied' stipend, access to lab",
                        "St Stephen's research scholar who was allegedly molested by a college professor,on Thursday alleged that she was denied payment of her stipend and access to the laboratory, a charge denied by the principal as \"constructed controversy\".\n" +
                                "The victim has also alleged that when she forcefully tried to enter the laboratory where she was conducting her research, she was locked by an attendant inside following which she had to call the police. While police officials confirmed of having received the call and visiting the campus but denied that the laboratory was found locked.\n" +
                                "\"Today when I went to the college to inquire about the release of my stipend, I was told by the concerned official in the college office that since Satish Kumar (her PhD supervisor) has not given his approval, the stipend could not be released,\" the victim alleged.",
                        "General",52,19,96,8,new Date(),"XYZ")
        );

        posts.add(
                new Post(3,"Kerala jail inmates to get personal email id",
                         "In a path-breaking move, all those currently lodged in jails across Kerala will soon get a personal email id.\n" +
                                 "As on July 1, there were 6,771 men and 193 women prisoners, including both convicts and under-trials, in the 55 jails in Kerala. Each inmate would now be given a personal email id by the jail department, said a press release issued here by department on Thursday.\n" +
                                 "It said the new directive comes as part of the state government's e-literacy programme. Director General of Police Loknath Behra, who is also the head of the prison department, told IANS that by the end of the month, each and every inmate will get their own email ids.",
                        "General",12,24,18,65,new Date(),"Attorny")
        );
    }

    public static List<Post> findAll(){
        return posts;
    }
    public static Post findByTitle(String title){
        for(Post post : posts){
            if (post.title.equals(title))
                return post;
        }
        return null;
    }

    public static void add(String title, String description, String category, String author){
        posts.add(new Post(title, description, category, author));
    }


}
