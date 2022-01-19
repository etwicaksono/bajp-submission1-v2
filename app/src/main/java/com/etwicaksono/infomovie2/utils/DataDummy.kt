package com.etwicaksono.infomovie2.utils

import com.etwicaksono.infomovie2.data.CatalogueModel
import com.etwicaksono.infomovie2.data.DetailItemModel

object DataDummy {
    fun getAllMovies(): List<CatalogueModel> {
        val movies = ArrayList<CatalogueModel>()

        movies.add(
            CatalogueModel(
                id = 524434,
                type = "TYPE_MOVIE",
                releaseDate = "2021-11-03",
                year = "2021",
                title = "Eternals",
                plot = "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
                posterPath = "/b6qUu00iIIkXX13szFy7d0CyNcg.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 585083,
                type = "TYPE_MOVIE",
                releaseDate = "2022-01-14",
                year = "2022",
                title = "Hotel Transylvania: Transformania",
                plot = "When Van Helsing's mysterious invention, the \"Monsterfication Ray,\" goes haywire, Drac and his monster pals are all transformed into humans, and Johnny becomes a monster. In their new mismatched bodies, Drac and Johnny must team up and race across the globe to find a cure before it's too late, and before they drive each other crazy.",
                posterPath = "/teCy1egGQa0y8ULJvlrDHQKnxBL.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 634649,
                type = "TYPE_MOVIE",
                releaseDate = "2021-12-15",
                year = "2021",
                title = "Spider-Man: No Way Home",
                plot = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                posterPath = "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 438695,
                type = "TYPE_MOVIE",
                releaseDate = "2021-12-01",
                year = "2021",
                title = "Sing 2",
                plot = "Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage.",
                posterPath = "/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 568124,
                type = "TYPE_MOVIE",
                releaseDate = "2021-11-24",
                year = "2021",
                title = "Encanto",
                plot = "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.",
                posterPath = "/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 425909,
                type = "TYPE_MOVIE",
                releaseDate = "2021-11-11",
                year = "2021",
                title = "Ghostbusters: Afterlife",
                plot = "When a single mom and her two kids arrive in a small town, they begin to discover their connection to the original Ghostbusters and the secret legacy their grandfather left behind.",
                posterPath = "/sg4xJaufDiQl7caFEskBtQXfD4x.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 460458,
                type = "TYPE_MOVIE",
                releaseDate = "2021-11-24",
                year = "2021",
                title = "Resident Evil: Welcome to Raccoon City",
                plot = "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night.",
                posterPath = "/7uRbWOXxpWDMtnsd2PF3clu65jc.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 624860,
                type = "TYPE_MOVIE",
                releaseDate = "2021-12-16",
                year = "2021",
                title = "The Matrix Resurrections",
                plot = "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix.",
                posterPath = "/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 860623,
                type = "TYPE_MOVIE",
                releaseDate = "2021-10-19",
                year = "2021",
                title = "Last Man Down",
                plot = "After civilization succumbs to a deadly pandemic and his wife is murdered, a special forces soldier abandons his duty and becomes a hermit in the Nordic wilderness. Years later, a wounded woman appears on his doorstep. She's escaped from a lab and her pursuers believe her blood is the key to a worldwide cure. He's hesitant to get involved, but all doubts are cast aside when he discovers her pursuer is none other than Commander Stone, the man that murdered his wife some years ago.",
                posterPath = "/4B7liCxNCZIZGONmAMkCnxVlZQV.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 580489,
                type = "TYPE_MOVIE",
                releaseDate = "2021-09-30",
                year = "2021",
                title = "Venom: Let There Be Carnage",
                plot = "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
                posterPath = "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 566525,
                type = "TYPE_MOVIE",
                releaseDate = "2021-09-01",
                year = "2021",
                title = "Shang-Chi and the Legend of the Ten Rings",
                plot = "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
                posterPath = "/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 739413,
                type = "TYPE_MOVIE",
                releaseDate = "2021-12-17",
                year = "2021",
                title = "Mother/Android",
                plot = "Georgia and her boyfriend Sam go on a treacherous journey to escape their country, which is caught in an unexpected war with artificial intelligence. Days away from the arrival of their first child, the couple must face No Man’s Land—a stronghold of the android uprising—in hopes of reaching safety before giving birth.",
                posterPath = "/rO3nV9d1wzHEWsC7xgwxotjZQpM.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 512195,
                type = "TYPE_MOVIE",
                releaseDate = "2021-11-04",
                year = "2021",
                title = "Red Notice",
                plot = "An Interpol-issued Red Notice is a global alert to hunt and capture the world's most wanted. But when a daring heist brings together the FBI's top profiler and two rival criminals, there's no telling what will happen.",
                posterPath = "/lAXONuqg41NwUMuzMiFvicDET9Y.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 763788,
                type = "TYPE_MOVIE",
                releaseDate = "2021-11-05",
                year = "2021",
                title = "Dangerous",
                plot = "A reformed sociopath heads to a remote island after the death of his brother. Soon after his arrival, the island falls under siege from a deadly gang of mercenaries, and when he discovers their role in his brother’s demise, he sets out on a relentless quest for vengeance.",
                posterPath = "/vTtkQGC7qKlSRQJZYtAWAmYdH0A.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 635302,
                type = "TYPE_MOVIE",
                releaseDate = "2020-10-16",
                year = "2020",
                title = "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                plot = "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                posterPath = "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 516329,
                type = "TYPE_MOVIE",
                releaseDate = "2021-10-28",
                year = "2021",
                title = "Antlers",
                plot = "A small-town Oregon teacher and her brother, the local sheriff, discover a young student is harbouring a dangerous secret that could have frightening consequences.",
                posterPath = "/cMch3tiexw3FdOEeZxMWVel61Xg.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 787310,
                type = "TYPE_MOVIE",
                releaseDate = "2021-10-08",
                year = "2021",
                title = "Survive the Game",
                plot = "When cop David is injured in a drug bust gone wrong, his partner Cal chases the two criminals who shot him. They all land at a remote farm owned by troubled vet Eric, and as Cal and Eric plot their defense, more of the gang arrives - along with a wounded David. Outnumbered, the three heroes must use stealth, smarts, and good shooting to take down the drug-dealing mob.",
                posterPath = "/xF1uc2pEf34X2G41wvZaF5H0V7C.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 585245,
                type = "TYPE_MOVIE",
                releaseDate = "2021-11-10",
                year = "2021",
                title = "Clifford the Big Red Dog",
                plot = "As Emily struggles to fit in at home and at school, she discovers a small red puppy who is destined to become her best friend. When Clifford magically undergoes one heck of a growth spurt, becomes a gigantic dog and attracts the attention of a genetics company, Emily and her Uncle Casey have to fight the forces of greed as they go on the run across New York City. Along the way, Clifford affects the lives of everyone around him and teaches Emily and her uncle the true meaning of acceptance and unconditional love.",
                posterPath = "/oifhfVhUcuDjE61V5bS5dfShQrm.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 826749,
                type = "TYPE_MOVIE",
                releaseDate = "2021-12-17",
                year = "2021",
                title = "Fortress",
                plot = "The story revolves around a top-secret resort for retired U.S. intelligence officers. A group of criminals led by Balzary breach the compound, hellbent on revenge on Robert, forcing the retired officer and his son to save the day.",
                posterPath = "/vQxtoPJVfpHgL7DCg9hQFZKDWJa.jpg",
            )
        )
        movies.add(
            CatalogueModel(
                id = 843241,
                type = "TYPE_MOVIE",
                releaseDate = "2021-07-02",
                year = "2021",
                title = "The Seven Deadly Sins: Cursed by Light",
                plot = "With the help of the \"Dragon Sin of Wrath\" Meliodas and the worst rebels in history, the Seven Deadly Sins, the \"Holy War\", in which four races, including Humans, Goddesses, Fairies and Giants fought against the Demons, is finally over. At the cost of the \"Lion Sin of Pride\" Escanor's life, the Demon King was defeated and the world regained peace. After that, each of the Sins take their own path.",
                posterPath = "/k0ThmZQl5nHe4JefC2bXjqtgYp0.jpg",
            )
        )

        return movies

    }

    fun getAllTvShows(): List<CatalogueModel> {
        val series = ArrayList<CatalogueModel>()

        series.add(
            CatalogueModel(
                id = 85552,
                type = "TYPE_TVSHOW",
                releaseDate = "2019-06-16",
                year = "2019",
                title = "Euphoria",
                plot = "A group of high school students navigate love and friendships in a world of drugs, sex, trauma, and social media.",
                posterPath = "/jtnfNzqZwN4E32FGGxx1YZaBWWf.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 115036,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-12-29",
                year = "2021",
                title = "The Book of Boba Fett",
                plot = "Legendary bounty hunter Boba Fett and mercenary Fennec Shand must navigate the galaxy’s underworld when they return to the sands of Tatooine to stake their claim on the territory once ruled by Jabba the Hutt and his crime syndicate.",
                posterPath = "/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 77169,
                type = "TYPE_TVSHOW",
                releaseDate = "2018-05-02",
                year = "2018",
                title = "Cobra Kai",
                plot = "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                posterPath = "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 2778,
                type = "TYPE_TVSHOW",
                releaseDate = "1983-09-19",
                year = "1983",
                title = "Wheel of Fortune",
                plot = "This game show sees contestants solve word puzzles, similar to those used in Hangman, to win cash and prizes determined by spinning a giant carnival wheel.",
                posterPath = "/2fvAIyVfFHQdhJ7OsJWuMlF7836.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 117031,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-01-18",
                year = "2021",
                title = "People Puzzler",
                plot = "Three lucky contestants put their pop culture knowledge to the test to complete iconic, People Puzzler crosswords. The player with the most points at the end of three rounds wins the game and goes on to play the \"Fast Puzzle Round\" for an enormous cash prize.",
                posterPath = "/gELQSCY5KKIGQAmOHbcgcRGNlp5.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 135753,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-12-13",
                year = "2021",
                title = "Love Twist",
                plot = "A drama depicting a sweet twist in love between the parents and children of three families around the love of two main characters.",
                posterPath = "/5bTF522eYn6g6r7aYqFpTZzmQq6.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 153748,
                type = "TYPE_TVSHOW",
                releaseDate = "2002-09-08",
                year = "2002",
                title = "Big Brother Famosos",
                plot = "Big Brother Famosos is the celebrity version of Big Brother Portugal.",
                posterPath = "/ra056721T5KEAsUnqQ2gulHJnQX.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 1416,
                type = "TYPE_TVSHOW",
                releaseDate = "2005-03-27",
                year = "2005",
                title = "Grey's Anatomy",
                plot = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                posterPath = "/zPIug5giU8oug6Xes5K1sTfQJxY.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 63174,
                type = "TYPE_TVSHOW",
                releaseDate = "2016-01-25",
                year = "2016",
                title = "Lucifer",
                plot = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                posterPath = "/ekZobS8isE6mA53RAiGDG93hBxL.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 71914,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-11-18",
                year = "2021",
                title = "The Wheel of Time",
                plot = "Follow Moiraine, a member of the shadowy and influential all-female organization called the “Aes Sedai” as she embarks on a dangerous, world-spanning journey with five young men and women. Moiraine believes one of them might be the reincarnation of an incredibly powerful individual, whom prophecies say will either save humanity or destroy it.",
                posterPath = "/mpgDeLhl8HbhI03XLB7iKO6M6JE.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 60574,
                type = "TYPE_TVSHOW",
                releaseDate = "2013-09-12",
                year = "2013",
                title = "Peaky Blinders",
                plot = "A gangster family epic set in 1919 Birmingham, England and centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby, who means to move up in the world.",
                posterPath = "/pE8CScObQURsFZ723PSW1K9EGYp.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 60735,
                type = "TYPE_TVSHOW",
                releaseDate = "2014-10-07",
                year = "2014",
                title = "The Flash",
                plot = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 96777,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-12-24",
                year = "2021",
                title = "The Silent Sea",
                plot = "During a perilous 24-hour mission on the moon, space explorers try to retrieve samples from an abandoned research facility steeped in classified secrets.",
                posterPath = "/fFT0IgqtCOks4munDTxQwkvNJkd.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 132375,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-11-08",
                year = "2021",
                title = "Um Lugar ao Sol",
                plot = "",
                posterPath = "/63qlVcvlVzOvMaFO8tFA2VG64Yc.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 124549,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-09-13",
                year = "2021",
                title = "Marry Me, Marry You",
                plot = "A couple navigates the traditional expectations attached to marriage — that it extends beyond one’s partner, and includes their friends and family, too.",
                posterPath = "/7qZUC0AQmSi7pxNP6cH3swkb8Is.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 117488,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-11-14",
                year = "2021",
                title = "Yellowjackets",
                plot = "This equal parts survival epic, psychological horror story and coming-of-age drama tells the saga of a team of wildly talented high school girls soccer players who become the (un)lucky survivors of a plane crash deep in the remote northern wilderness. The series chronicles their descent from a complicated but thriving team to savage clans, while also tracking the lives they’ve attempted to piece back together nearly 25 years later.",
                posterPath = "/XtnjzjjFAnmTEiDk4xu7diCvMF.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 88329,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-11-24",
                year = "2021",
                title = "Hawkeye",
                plot = "Former Avenger Clint Barton has a seemingly simple mission: get back to his family for Christmas. Possible? Maybe with the help of Kate Bishop, a 22-year-old archer with dreams of becoming a superhero. The two are forced to work together when a presence from Barton’s past threatens to derail far more than the festive spirit.",
                posterPath = "/pqzjCxPVc9TkVgGRWeAoMmyqkZV.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 122551,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-11-15",
                year = "2021",
                title = "Viral Scandal",
                plot = "The lives of a simple family becomes disrupted when a scandalous video involving their eldest daughter goes viral.",
                posterPath = "/zPsJG3DRDeZZCoja9nnU6p4d67V.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 90462,
                type = "TYPE_TVSHOW",
                releaseDate = "2021-10-12",
                year = "2021",
                title = "Chucky",
                plot = "After a vintage Chucky doll turns up at a suburban yard sale, an idyllic American town is thrown into chaos as a series of horrifying murders begin to expose the town’s hypocrisies and secrets. Meanwhile, the arrival of enemies — and allies — from Chucky’s past threatens to expose the truth behind the killings, as well as the demon doll’s untold origins.",
                posterPath = "/iF8ai2QLNiHV4anwY1TuSGZXqfN.jpg",
            )
        )

        series.add(
            CatalogueModel(
                id = 134949,
                type = "TYPE_TVSHOW",
                releaseDate = "2022-01-05",
                year = "2022",
                title = "Rebelde",
                plot = "Head back to Elite Way School as a new generation of students hope to win the Battle of the Bands.",
                posterPath = "/jRlI5euugVZR6a1Ptt0nSWeiWH.jpg",
            )
        )


        return series
    }

    fun getMovie(): DetailItemModel {
        return DetailItemModel(
            backdropPath = "/c6H7Z4u73ir3cIoCteuhJh7UCAR.jpg",
            genres = "Action, Adventure, Fantasy, Science Fiction",
            id = 524434,
            overview = "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
            posterPath = "/b6qUu00iIIkXX13szFy7d0CyNcg.jpg",
            releaseDate = "2021-11-03",
            year = "2021",
            runtime = "2h 36m",
            title = "Eternals",
            voteAverage = "7.2",
        )
    }
    fun getTvShow(): DetailItemModel {
        return DetailItemModel(
            backdropPath = "/yfXSvNfF43S0cxpxCEKaU17yZ64.jpg",
            genres = "Family",
            id = 2778,
            overview = "This game show sees contestants solve word puzzles, similar to those used in Hangman, to win cash and prizes determined by spinning a giant carnival wheel.",
            posterPath = "/2fvAIyVfFHQdhJ7OsJWuMlF7836.jpg",
            releaseDate = "1983-09-19",
            year = "1983",
            runtime = "25m",
            title = "Wheel of Fortune",
            voteAverage = "6.8",
        )
    }
}