package com.wdhurleyjr.cst338_total_trivia.DB.Game;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Game.class, Question.class}, version = 2)

public abstract class GameDataBase extends RoomDatabase {
    public static final String GAME_DATA_BASE_NAME = "Game.DB";
    public static final String GAME_TABLE = "game_table";

    private static volatile GameDataBase instance;
    private static final Object LOCK = new Object();
    private static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);
    public abstract GameDao GameDao();
    public abstract QuestionDao QuestionDao();




    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                GameDao gameDao = instance.GameDao();
                QuestionDao questionDao = instance.QuestionDao();

                String game1id = "1";
                Game game1 = new Game(game1id, "Harry Potter Trivia");
                gameDao.insert(game1);

                Question[] harryPotterQuestions = {
                        new Question(
                                1,
                                game1id,
                                "What house at Hogwarts does Harry belong to?",
                                "Gryffindor",
                                "Slytherin",
                                "Ravenclaw",
                                "Hufflepuff",
                                "Gryffindor",
                                false
                        ),
                        new Question(
                                2,
                                game1id,
                                "Who is Fluffy?",
                                "A dragon",
                                "A three-headed dog",
                                "A giant spider",
                                "A centaur",
                                "A three-headed dog",
                                false
                        ),
                        new Question(
                                3,
                                game1id,
                                "What position does Harry play on his Quidditch team?",
                                "Chaser",
                                "Bludger",
                                "Keeper",
                                "Seeker",
                                "Seeker",
                                false
                        ),
                        new Question(
                                4,
                                game1id,
                                "What does the spell 'Lumos' do?",
                                "Levitates objects",
                                "Creates light",
                                "Unlocks doors",
                                "Disarms opponents",
                                "Creates light",
                                false
                        ),
                        new Question(
                                5,
                                game1id,
                                "Which professor teaches Transfiguration at Hogwarts?",
                                "Severus Snape",
                                "Sybill Trelawney",
                                "Minerva McGonagall",
                                "Filius Flitwick",
                                "Minerva McGonagall",
                                false
                        ),
                        new Question(
                                6,
                                game1id,
                                "What is the core material of Harry’s wand?",
                                "Dragon heartstring",
                                "Unicorn hair",
                                "Phoenix feather",
                                "Veela hair",
                                "Phoenix feather",
                                false
                        ),
                        new Question(
                                7,
                                game1id,
                                "What magical plant does Harry use to breathe underwater in the Triwizard Tournament?",
                                "Devil's Snare",
                                "Whomping Willow",
                                "Gillyweed",
                                "Mandrake",
                                "Gillyweed",
                                false
                        ),
                        new Question(
                                8,
                                game1id,
                                "Who is the Half-Blood Prince?",
                                "Albus Dumbledore",
                                "Harry Potter",
                                "Severus Snape",
                                "Tom Riddle",
                                "Severus Snape",
                                false
                        ),
                        new Question(
                                9,
                                game1id,
                                "Which magical creature is NOT found in the Forbidden Forest?",
                                "Centaurs",
                                "Unicorns",
                                "Basilisks",
                                "Acromantulas",
                                "Basilisks",
                                false
                        ),
                        new Question(
                                10,
                                game1id,
                                "What is the name of Hermione’s cat?",
                                "Crookshanks",
                                "Norbert",
                                "Scabbers",
                                "Hedwig",
                                "Crookshanks",
                                false
                        ),
                        new Question(
                                11,
                                game1id,
                                "Which item is NOT one of the Deathly Hallows?",
                                "Elder Wand",
                                "Resurrection Stone",
                                "Cloak of Invisibility",
                                "Sorcerer's Stone",
                                "Sorcerer's Stone",
                                false
                        ),
                        new Question(
                                12,
                                game1id,
                                "Who destroys the final Horcrux?",
                                "Hermione Granger",
                                "Ron Weasley",
                                "Neville Longbottom",
                                "Harry Potter",
                                "Neville Longbottom",
                                false
                        ),
                        new Question(
                                13,
                                game1id,
                                "What is Voldemort’s real name?",
                                "Sirius Black",
                                "Severus Snape",
                                "Tom Marvolo Riddle",
                                "Lucius Malfoy",
                                "Tom Marvolo Riddle",
                                false
                        ),
                        new Question(
                                14,
                                game1id,
                                "Who is NOT a member of the Order of the Phoenix?",
                                "Nymphadora Tonks",
                                "Mad-Eye Moody",
                                "Bellatrix Lestrange",
                                "Kingsley Shacklebolt",
                                "Bellatrix Lestrange",
                                false
                        ),
                        new Question(
                                15,
                                game1id,
                                "What does the Imperius Curse do?",
                                "Controls",
                                "Tortures",
                                "Kills",
                                "Protects",
                                "Controls",
                                false
                        ),
                        new Question(
                                16,
                                game1id,
                                "Which class is taught by Professor Binns?",
                                "Divination",
                                "History of Magic",
                                "Defense Against the Dark Arts",
                                "Herbology",
                                "History of Magic",
                                false
                        ),
                        new Question(
                                17,
                                game1id,
                                "Where do the Dursleys live?",
                                "Little Whinging, Surrey",
                                "Ottery St Catchpole",
                                "Godric's Hollow",
                                "Spinner's End",
                                "Little Whinging, Surrey",
                                false
                        ),
                        new Question(
                                18,
                                game1id,
                                "Who originally owned the Elder Wand?",
                                "Dumbledore",
                                "Draco Malfoy",
                                "Harry Potter",
                                "Antioch Peverell",
                                "Antioch Peverell",
                                false
                        ),
                        new Question(
                                19,
                                game1id,
                                "What is NOT a form of wizard transportation?",
                                "Floo Powder",
                                "Portkeys",
                                "Broomsticks",
                                "Cars",
                                "Cars",
                                false
                        ),
                        new Question(
                                20,
                                game1id,
                                "Which potion is commonly known as Liquid Luck?",
                                "Polyjuice Potion",
                                "Amortentia",
                                "Felix Felicis",
                                "Veritaserum",
                                "Felix Felicis",
                                false
                        )
                };
                questionDao.insert(harryPotterQuestions);


                String game2id = "2";
                Game game2 = new Game(game2id, "Star Wars Trivia");
                gameDao.insert(game2);

                Question[] starWarsQuestions = {
                        new Question(
                                1,
                                game2id,
                                "Who is Luke Skywalker's father?",
                                "Obi-Wan Kenobi",
                                "Anakin Skywalker",
                                "Yoda",
                                "Mace Windu",
                                "Anakin Skywalker",
                                false
                        ),
                        new Question(
                                2,
                                game2id,
                                "What species is Chewbacca?",
                                "Ewok",
                                "Rodian",
                                "Wookiee",
                                "Bothan",
                                "Wookiee",
                                false
                        ),
                        new Question(
                                3,
                                game2id,
                                "Who is the pilot of the Millennium Falcon?",
                                "Lando Calrissian",
                                "Han Solo",
                                "Poe Dameron",
                                "Luke Skywalker",
                                "Han Solo",
                                false
                        ),
                        new Question(
                                4,
                                game2id,
                                "What planet is Princess Leia from?",
                                "Alderaan",
                                "Naboo",
                                "Tatooine",
                                "Corellia",
                                "Alderaan",
                                false
                        ),
                        new Question(
                                5,
                                game2id,
                                "Who built C-3PO?",
                                "Obi-Wan Kenobi",
                                "Anakin Skywalker",
                                "Luke Skywalker",
                                "Qui-Gon Jinn",
                                "Anakin Skywalker",
                                false
                        ),
                        new Question(
                                6,
                                game2id,
                                "What color is Mace Windu's lightsaber?",
                                "Blue",
                                "Green",
                                "Purple",
                                "Red",
                                "Purple",
                                false
                        ),
                        new Question(
                                7,
                                game2id,
                                "Who is the Supreme Leader of the First Order?",
                                "Kylo Ren",
                                "Snoke",
                                "General Hux",
                                "Captain Phasma",
                                "Snoke",
                                false
                        ),
                        new Question(
                                8,
                                game2id,
                                "What is the name of Boba Fett's ship?",
                                "Slave I",
                                "Executor",
                                "Death Star",
                                "Millennium Falcon",
                                "Slave I",
                                false
                        ),
                        new Question(
                                9,
                                game2id,
                                "Who is the first character to speak in the original Star Wars (Episode IV: A New Hope)?",
                                "Darth Vader",
                                "C-3PO",
                                "Princess Leia",
                                "R2-D2",
                                "C-3PO",
                                false
                        ),
                        new Question(
                                10,
                                game2id,
                                "Who kills Jabba the Hutt?",
                                "Han Solo",
                                "Princess Leia",
                                "Luke Skywalker",
                                "Boba Fett",
                                "Princess Leia",
                                false
                        ),
                        new Question(
                                11,
                                game2id,
                                "Which planet is home to the Ewoks?",
                                "Endor",
                                "Tatooine",
                                "Kashyyyk",
                                "Hoth",
                                "Endor",
                                false
                        ),
                        new Question(
                                12,
                                game2id,
                                "Who trains Luke Skywalker in the ways of the Jedi after Obi-Wan Kenobi's death?",
                                "Yoda",
                                "Mace Windu",
                                "Qui-Gon Jinn",
                                "Anakin Skywalker",
                                "Yoda",
                                false
                        ),
                        new Question(
                                13,
                                game2id,
                                "Who defeats Count Dooku in Episode III: Revenge of the Sith?",
                                "Obi-Wan Kenobi",
                                "Anakin Skywalker",
                                "Mace Windu",
                                "Yoda",
                                "Anakin Skywalker",
                                false
                        ),
                        new Question(
                                14,
                                game2id,
                                "What is the name of the princess who becomes a senator and leads the Rebel Alliance?",
                                "Padmé Amidala",
                                "Leia Organa",
                                "Mon Mothma",
                                "Ahsoka Tano",
                                "Leia Organa",
                                false
                        ),
                        new Question(
                                15,
                                game2id,
                                "Which character is known for saying, 'I have a bad feeling about this'?",
                                "Han Solo",
                                "Luke Skywalker",
                                "Obi-Wan Kenobi",
                                "All of the above",
                                "All of the above",
                                false
                        ),
                        new Question(
                                16,
                                game2id,
                                "What is the name of the bounty hunter who captures Han Solo in Episode V: The Empire Strikes Back?",
                                "Boba Fett",
                                "Greedo",
                                "Bossk",
                                "Dengar",
                                "Boba Fett",
                                false
                        ),
                        new Question(
                                17,
                                game2id,
                                "Who becomes Darth Vader's apprentice in the Star Wars expanded universe?",
                                "Galen Marek",
                                "Mara Jade",
                                "Asajj Ventress",
                                "Count Dooku",
                                "Galen Marek",
                                false
                        ),
                        new Question(
                                18,
                                game2id,
                                "What is the name of the weapon used to destroy the Death Star in Episode IV: A New Hope?",
                                "Proton Torpedo",
                                "Thermal Detonator",
                                "Ion Cannon",
                                "Concussion Missile",
                                "Proton Torpedo",
                                false
                        ),
                        new Question(
                                19,
                                game2id,
                                "Who is responsible for creating the Clone Army?",
                                "Count Dooku",
                                "Jango Fett",
                                "Sifo-Dyas",
                                "Darth Sidious",
                                "Sifo-Dyas",
                                false
                        ),
                        new Question(
                                20,
                                game2id,
                                "Who is the voice of Darth Vader in the original trilogy?",
                                "David Prowse",
                                "James Earl Jones",
                                "Frank Oz",
                                "Mark Hamill",
                                "James Earl Jones",
                                false
                        )
                };
                questionDao.insert(starWarsQuestions);


//                String game3id = "3";
//                Game game3 = new Game(game3id, "Disney Trivia");
//                gameDao.insert(game3);
//
//                Question[] disneyQuestions = {
//                        new Question(
//                                1,
//                                game3id,
//                                "What is the name of the princess in 'The Little Mermaid'?",
//                                "Ariel",
//                                "Jasmine",
//                                "Aurora",
//                                "Belle",
//                                "Ariel",
//                                false
//                        ),
//                        new Question(
//                                2,
//                                game3id,
//                                "Who is the main villain in 'The Lion King'?",
//                                "Scar",
//                                "Shere Khan",
//                                "Captain Hook",
//                                "Jafar",
//                                "Scar",
//                                false
//                        ),
//                        new Question(
//                                3,
//                                game3id,
//                                "What is the name of the kingdom in 'Frozen'?",
//                                "Arendelle",
//                                "Corona",
//                                "Atlantica",
//                                "Agrabah",
//                                "Arendelle",
//                                false
//                        ),
//                        new Question(
//                                4,
//                                game3id,
//                                "Who provides the voice of Genie in the original 'Aladdin' movie?",
//                                "Robin Williams",
//                                "Eddie Murphy",
//                                "Mike Myers",
//                                "Steve Martin",
//                                "Robin Williams",
//                                false
//                        ),
//                        new Question(
//                                5,
//                                game3id,
//                                "What animal is Simba from 'The Lion King'?",
//                                "Lion",
//                                "Tiger",
//                                "Bear",
//                                "Panther",
//                                "Lion",
//                                false
//                        ),
//                        new Question(
//                                6,
//                                game3id,
//                                "Who is the sea witch in 'The Little Mermaid'?",
//                                "Ursula",
//                                "Maleficent",
//                                "Cruella de Vil",
//                                "Yzma",
//                                "Ursula",
//                                false
//                        ),
//                        new Question(
//                                7,
//                                game3id,
//                                "Where does Mowgli grow up in 'The Jungle Book'?",
//                                "The jungle",
//                                "A forest",
//                                "A city",
//                                "The savanna",
//                                "The jungle",
//                                false
//                        ),
//                        new Question(
//                                8,
//                                game3id,
//                                "Which movie features the song 'Circle of Life'?",
//                                "The Lion King",
//                                "Tarzan",
//                                "Mulan",
//                                "Hercules",
//                                "The Lion King",
//                                false
//                        ),
//                        new Question(
//                                9,
//                                game3id,
//                                "Who is the villain in 'Sleeping Beauty'?",
//                                "Maleficent",
//                                "Ursula",
//                                "Hades",
//                                "Captain Hook",
//                                "Maleficent",
//                                false
//                        ),
//                        new Question(
//                                10,
//                                game3id,
//                                "What does Aladdin use to travel around in 'Aladdin'?",
//                                "A magic carpet",
//                                "A flying horse",
//                                "A hot air balloon",
//                                "A broomstick",
//                                "A magic carpet",
//                                false
//                        ),
//                        new Question(
//                                11,
//                                game3id,
//                                "What is the name of the talking snowman in 'Frozen'?",
//                                "Olaf",
//                                "Sven",
//                                "Kristoff",
//                                "Oaken",
//                                "Olaf",
//                                false
//                        ),
//                        new Question(
//                                12,
//                                game3id,
//                                "Who is the prince in 'Sleeping Beauty'?",
//                                "Prince Philip",
//                                "Prince Charming",
//                                "Prince Eric",
//                                "Prince John",
//                                "Prince Philip",
//                                false
//                        ),
//                        new Question(
//                                13,
//                                game3id,
//                                "What is the name of Belle's father in 'Beauty and the Beast'?",
//                                "Maurice",
//                                "Gaston",
//                                "Lumière",
//                                "Cogsworth",
//                                "Maurice",
//                                false
//                        ),
//                        new Question(
//                                14,
//                                game3id,
//                                "What does Rafiki do when he meets Simba in 'The Lion King'?",
//                                "He presents Simba to the other animals.",
//                                "He paints on Simba's forehead.",
//                                "He gives Simba a banana.",
//                                "He roars at Simba.",
//                                "He paints on Simba's forehead",
//                                false
//                        ),
//                        new Question(
//                                15,
//                                game3id,
//                                "What is the name of Cinderella's stepmother?",
//                                "Lady Tremaine",
//                                "Lady Macbeth",
//                                "Lady Gothel",
//                                "Lady Pomfrey",
//                                "Lady Tremaine",
//                                false
//                        ),
//                        new Question(
//                                16,
//                                game3id,
//                                "What are the names of Hades' minions in 'Hercules'?",
//                                "Pain and Panic",
//                                "Shock and Scare",
//                                "Pain and Scare",
//                                "Pain and Shock",
//                                "Pain and Panic",
//                                false
//                        ),
//                        new Question(
//                                17,
//                                game3id,
//                                "Which princess has a pet tiger named Rajah?",
//                                "Jasmine",
//                                "Aurora",
//                                "Cinderella",
//                                "Belle",
//                                "Jasmine",
//                                false
//                        ),
//                        new Question(
//                                18,
//                                game3id,
//                                "What is the name of the evil queen in 'Snow White and the Seven Dwarfs'?",
//                                "Queen Grimhilde",
//                                "Queen Maleficent",
//                                "Queen Ursula",
//                                "Queen Regina",
//                                "Queen Grimhilde",
//                                false
//                        ),
//                        new Question(
//                                19,
//                                game3id,
//                                "What do the seven dwarfs work as in 'Snow White and the Seven Dwarfs'?",
//                                "Miners",
//                                "Carpenters",
//                                "Blacksmiths",
//                                "Merchants",
//                                "Miners",
//                                false
//                        ),
//                        new Question(
//                                20,
//                                game3id,
//                                "Who is the villain in '101 Dalmatians'?",
//                                "Cruella de Vil",
//                                "Captain Hook",
//                                "Hades",
//                                "Maleficent",
//                                "Cruella de Vil",
//                                false
//                        )
//                };
//                questionDao.insert(disneyQuestions);
//
//
//                String game4id = "4";
//                Game game4 = new Game(game4id, "Marvel Trivia");
//                gameDao.insert(game4);
//
//                Question[] marvelQuestions = {
//                        new Question(
//                                1,
//                                game4id,
//                                "Who is the alter ego of Spider-Man?",
//                                "Peter Parker",
//                                "Tony Stark",
//                                "Bruce Wayne",
//                                "Steve Rogers",
//                                "Peter Parker",
//                                false
//                        ),
//                        new Question(
//                                2,
//                                game4id,
//                                "What is the name of Thor's hammer?",
//                                "Mjolnir",
//                                "Gungnir",
//                                "Stormbreaker",
//                                "Excalibur",
//                                "Mjolnir",
//                                false
//                        ),
//                        new Question(
//                                3,
//                                game4id,
//                                "Which hero is known as the 'Sorcerer Supreme'?",
//                                "Doctor Strange",
//                                "Doctor Doom",
//                                "Scarlet Witch",
//                                "Loki",
//                                "Doctor Strange",
//                                false
//                        ),
//                        new Question(
//                                4,
//                                game4id,
//                                "What is Captain America's shield made from?",
//                                "Vibranium",
//                                "Adamantium",
//                                "Steel",
//                                "Titanium",
//                                "Vibranium",
//                                false
//                        ),
//                        new Question(
//                                5,
//                                game4id,
//                                "Who is Tony Stark's assistant and later becomes the CEO of Stark Industries?",
//                                "Pepper Potts",
//                                "Natasha Romanoff",
//                                "Sharon Carter",
//                                "Peggy Carter",
//                                "Pepper Potts",
//                                false
//                        ),
//                        new Question(
//                                6,
//                                game4id,
//                                "Who is Black Panther's real identity?",
//                                "T'Challa",
//                                "Shuri",
//                                "M'Baku",
//                                "Killmonger",
//                                "T'Challa",
//                                false
//                        ),
//                        new Question(
//                                7,
//                                game4id,
//                                "What group is known for fighting against mutants in the X-Men universe?",
//                                "The Brotherhood",
//                                "The Sentinels",
//                                "The Avengers",
//                                "The Chitauri",
//                                "The Sentinels",
//                                false
//                        ),
//                        new Question(
//                                8,
//                                game4id,
//                                "Who does Loki disguise himself as in 'The Avengers'?",
//                                "Odin",
//                                "Captain America",
//                                "Thor",
//                                "Nick Fury",
//                                "Captain America",
//                                false
//                        ),
//                        new Question(
//                                9,
//                                game4id,
//                                "Who are the two Guardians of the Galaxy known for bickering?",
//                                "Rocket and Groot",
//                                "Drax and Gamora",
//                                "Star-Lord and Gamora",
//                                "Star-Lord and Rocket",
//                                "Star-Lord and Rocket",
//                                false
//                        ),
//                        new Question(
//                                10,
//                                game4id,
//                                "What is Black Widow's real name?",
//                                "Natasha Romanoff",
//                                "Wanda Maximoff",
//                                "Carol Danvers",
//                                "Jennifer Walters",
//                                "Natasha Romanoff",
//                                false
//                        ),
//                        new Question(
//                                11,
//                                game4id,
//                                "Who becomes the Falcon in the Marvel Cinematic Universe?",
//                                "Sam Wilson",
//                                "Bucky Barnes",
//                                "Steve Rogers",
//                                "Clint Barton",
//                                "Sam Wilson",
//                                false
//                        ),
//                        new Question(
//                                12,
//                                game4id,
//                                "Which villain creates the Ultron robot in 'Avengers: Age of Ultron'?",
//                                "Tony Stark",
//                                "Bruce Banner",
//                                "Hank Pym",
//                                "Reed Richards",
//                                "Tony Stark",
//                                false
//                        ),
//                        new Question(
//                                13,
//                                game4id,
//                                "Who is the Winter Soldier's true identity?",
//                                "Bucky Barnes",
//                                "Sam Wilson",
//                                "Steve Rogers",
//                                "Tony Stark",
//                                "Bucky Barnes",
//                                false
//                        ),
//                        new Question(
//                                14,
//                                game4id,
//                                "Who leads the Avengers in most of the Marvel Cinematic Universe films?",
//                                "Steve Rogers",
//                                "Tony Stark",
//                                "Natasha Romanoff",
//                                "Nick Fury",
//                                "Steve Rogers",
//                                false
//                        ),
//                        new Question(
//                                15,
//                                game4id,
//                                "Which group does Gamora belong to?",
//                                "Guardians of the Galaxy",
//                                "Avengers",
//                                "X-Men",
//                                "Fantastic Four",
//                                "Guardians of the Galaxy",
//                                false
//                        ),
//                        new Question(
//                                16,
//                                game4id,
//                                "Who is the villain in the first 'Avengers' movie?",
//                                "Loki",
//                                "Ultron",
//                                "Thanos",
//                                "Red Skull",
//                                "Loki",
//                                false
//                        ),
//                        new Question(
//                                17,
//                                game4id,
//                                "Who is the oldest of the four siblings in 'The Incredibles'?",
//                                "Violet",
//                                "Dash",
//                                "Jack-Jack",
//                                "Bob",
//                                "Violet",
//                                false
//                        ),
//                        new Question(
//                                18,
//                                game4id,
//                                "What is the name of Spider-Man's best friend in the Marvel Cinematic Universe?",
//                                "Ned Leeds",
//                                "Harry Osborn",
//                                "Flash Thompson",
//                                "MJ",
//                                "Ned Leeds",
//                                false
//                        ),
//                        new Question(
//                                19,
//                                game4id,
//                                "Who is the leader of the X-Men?",
//                                "Professor X",
//                                "Cyclops",
//                                "Wolverine",
//                                "Storm",
//                                "Professor X",
//                                false
//                        ),
//                        new Question(
//                                20,
//                                game4id,
//                                "Which character wields a shield with a star on it?",
//                                "Captain America",
//                                "Bucky Barnes",
//                                "Sam Wilson",
//                                "Peggy Carter",
//                                "Captain America",
//                                false
//                        )
//                };
//                questionDao.insert(marvelQuestions);
            });
        }
    };

    public static GameDataBase getInstance(Context context){
        if(instance == null){
            synchronized (LOCK){
                if (instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(), GameDataBase.class, GAME_DATA_BASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }

//    public static GameDataBase getInstance(Context context) {
//        if (instance == null) {
//            synchronized (LOCK) {
//                if (instance == null) {
//                    // Build the Room database instance
//                    instance = Room.databaseBuilder(context.getApplicationContext(), GameDataBase.class, GAME_DATA_BASE_NAME)
//                            .addCallback(addDefaultValues)
//                            .build();
//                }
//            }
//        }
//        return instance;
//    }
}
