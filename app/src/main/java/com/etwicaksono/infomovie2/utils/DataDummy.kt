package com.etwicaksono.infomovie2.utils

import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.data.MovieModel

object DataDummy {
    fun getAllMovies(): List<MovieModel> {
        val movies = ArrayList<MovieModel>()

        movies.add(
            MovieModel(
                1,
                "movies",
                "ALITA: BATTLE ANGEL",
                "2019",
                "January 31, 2019",
                "122",
                "Action, Science Fiction, Adventure",
                "Robert Rodriguez",
                "Rosa Salazar, Christoph Waltz, Jennifer Connelly, Mahershala Ali",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                R.drawable.poster_alita
            )
        )
        movies.add(
            MovieModel(
                2,
                "movies",
                "AQUAMAN",
                "2018",
                "July 6, 2018",
                "143",
                "Action, Adventure, Fantasy",
                "James Wan",
                "Jason Momoa, Amber Heard, Willem Dafoe, Patrick Wilson",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                R.drawable.poster_aquaman
            )
        )
        movies.add(
            MovieModel(
                3,
                "movies",
                "A STAR IS BORN",
                "2018",
                "October 3, 2018",
                "136",
                "Drama, Romance",
                "Bradley Cooper",
                "Bradley Cooper, Lady Gaga, Sam Elliott, Andrew Dice Clay",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                R.drawable.poster_a_star_is_born
            )
        )
        movies.add(
            MovieModel(
                4,
                "movies",
                "BOHEMIAN RHAPSODY",
                "2018",
                "October 24, 2018",
                "135",
                "Music, Drama, History",
                "Bryan Singer",
                "Rami Malek, Gwilym Lee, Ben Hardy, Joseph Mazello",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                R.drawable.poster_bohemian
            )
        )
        movies.add(
            MovieModel(
                5,
                "movies",
                "COLD PURSUIT",
                "2019",
                "February 7, 2019",
                "119",
                "Action, Crime, Thriller",
                "Hans Petter Moland",
                "Liam Neeson, Laura Dern, Emmy Rossum, Michael Eklund",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                R.drawable.poster_cold_pursuit
            )
        )
        movies.add(
            MovieModel(
                6,
                "movies",
                "CREED II",
                "2018",
                "November 21, 2018",
                "130",
                "Drama",
                "Steven Caple Jr.",
                "Michael B. Jordan, Syvester Stallone, Dolph Lundgren, Florian Munteanu",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                R.drawable.poster_creed
            )
        )
        movies.add(
            MovieModel(
                7,
                "movies",
                "FANTASTIC BEAST: THE CRIMES OF GRINDELWALD",
                "2018",
                "November 16, 2018",
                "134",
                "Adventure, Fantasy, Drama",
                "David Yates",
                "Eddie Redmayne, Katherine Waterston, Dan Fogler, Alison Sudol",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                R.drawable.poster_crimes
            )
        )
        movies.add(
            MovieModel(
                8,
                "movies",
                "GLASS",
                "2019",
                "January 18, 2019",
                "129",
                "Thriller, Drama, Science Fiction",
                "M. Night Shymalan",
                "James McAvoy, Bruce Willis, Samuel L. Jackson, Anya Taylor Joy",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                R.drawable.poster_glass
            )
        )
        movies.add(
            MovieModel(
                9,
                "movies",
                "HOW TO TRAIN YOUR DRAGON",
                "2010",
                "March 26, 2010",
                "98",
                "Fantasy, Anventure, Animation, Family",
                "Chris Sanders",
                "Jay Baruchel, Gerard Butler, Craig Fergusin, America Ferrera",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                R.drawable.poster_how_to_train
            )
        )
        movies.add(
            MovieModel(
                10,
                "movies",
                "AVENGERS: INFINITY WAR",
                "2018",
                "April 27, 2018",
                "149",
                "Adventure, Action, Science Fiction",
                "Anthony Russo",
                "Robert Downey Jr., Mark Ruffalo, Chris Hemsworth, Chris Evans",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                R.drawable.poster_infinity_war
            )
        )
        movies.add(
            MovieModel(
                11,
                "movies",
                "MARRY QUEEN",
                "2018",
                "December 21, 2018",
                "124",
                "Drama, History",
                "Josie Rourke",
                "Saoirse Ronan, Margot Robbie, Jack Lowden, Joe Alwyn",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                R.drawable.poster_marry_queen
            )
        )
        movies.add(
            MovieModel(
                12,
                "movies",
                "MASTER Z: IP MAN LEGACY",
                "2018",
                "December 26, 2018",
                "107",
                "Action",
                "Yuen Woo Ping",
                "Zhang Jin, Dave Bautista, Liu yan, Xing Yu",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                R.drawable.poster_master_z
            )
        )
        movies.add(
            MovieModel(
                13,
                "movies",
                "MORTAL ENGINES",
                "2018",
                "December 14, 2018",
                "129",
                "Adventure, Science Fiction",
                "Christian Rivers",
                "Hera Hilmar, Robert Sheehan, Hugo Weaving, Jihae",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.\n\n Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolorum perferendis officiis molestias dolor. Delectus laboriosam dignissimos quis iusto cumque non modi, eveniet nesciunt quidem maxime accusantium ea a illo unde! Lorem ipsum dolor sit amet consectetur adipisicing elit. Dicta laboriosam nobis dolores, deleniti eos consequuntur eaque. Cumque rerum natus, quidem ad laborum, totam sequi perspiciatis recusandae exercitationem, accusamus expedita necessitatibus? Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nostrum labore, beatae blanditiis provident dolor, culpa quos ipsa magni expedita ab laboriosam aut minus perferendis ipsam consequuntur molestias vitae veritatis maiores? Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquid eligendi qui nostrum amet, ipsum quaerat corporis sit quis corrupti est accusamus cupiditate repellat pariatur repellendus accusantium fugiat, adipisci ad enim. Lorem ipsum dolor, sit amet consectetur adipisicing elit. Cumque perferendis numquam, quos dignissimos quia eaque quo dolore debitis sed consequuntur a? Quas ratione sunt numquam quo aliquid voluptatibus itaque architecto. Lorem ipsum dolor sit amet consectetur adipisicing elit. Earum, fuga accusamus minima ab illo asperiores beatae cumque. Dolorum at quae, nesciunt minima provident deleniti. Minus ut adipisci soluta voluptatibus illum? Lorem ipsum, dolor sit amet consectetur adipisicing elit. Enim fugiat ea inventore officia perspiciatis praesentium reprehenderit sunt numquam doloremque libero, veniam officiis eius consequuntur natus totam minima exercitationem veritatis eaque. Lorem ipsum, dolor sit amet consectetur adipisicing elit. Atque aspernatur asperiores neque ipsam doloribus inventore voluptas officia blanditiis aliquid minus dicta, debitis rem praesentium temporibus deserunt voluptates libero quas et. Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem tempora, consequuntur eos odio distinctio, cupiditate dolorem excepturi rem sint sunt voluptatibus deleniti officia error quasi fuga a architecto enim minima? Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos, odit ad officiis distinctio dignissimos rem voluptate ipsum hic eaque, facilis deleniti doloremque assumenda nisi nesciunt dolorem at velit consequuntur reiciendis!\n\n Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolorum perferendis officiis molestias dolor. Delectus laboriosam dignissimos quis iusto cumque non modi, eveniet nesciunt quidem maxime accusantium ea a illo unde! Lorem ipsum dolor sit amet consectetur adipisicing elit. Dicta laboriosam nobis dolores, deleniti eos consequuntur eaque. Cumque rerum natus, quidem ad laborum, totam sequi perspiciatis recusandae exercitationem, accusamus expedita necessitatibus? Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nostrum labore, beatae blanditiis provident dolor, culpa quos ipsa magni expedita ab laboriosam aut minus perferendis ipsam consequuntur molestias vitae veritatis maiores? Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquid eligendi qui nostrum amet, ipsum quaerat corporis sit quis corrupti est accusamus cupiditate repellat pariatur repellendus accusantium fugiat, adipisci ad enim. Lorem ipsum dolor, sit amet consectetur adipisicing elit. Cumque perferendis numquam, quos dignissimos quia eaque quo dolore debitis sed consequuntur a? Quas ratione sunt numquam quo aliquid voluptatibus itaque architecto. Lorem ipsum dolor sit amet consectetur adipisicing elit. Earum, fuga accusamus minima ab illo asperiores beatae cumque. Dolorum at quae, nesciunt minima provident deleniti. Minus ut adipisci soluta voluptatibus illum? Lorem ipsum, dolor sit amet consectetur adipisicing elit. Enim fugiat ea inventore officia perspiciatis praesentium reprehenderit sunt numquam doloremque libero, veniam officiis eius consequuntur natus totam minima exercitationem veritatis eaque. Lorem ipsum, dolor sit amet consectetur adipisicing elit. Atque aspernatur asperiores neque ipsam doloribus inventore voluptas officia blanditiis aliquid minus dicta, debitis rem praesentium temporibus deserunt voluptates libero quas et. Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem tempora, consequuntur eos odio distinctio, cupiditate dolorem excepturi rem sint sunt voluptatibus deleniti officia error quasi fuga a architecto enim minima? Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos, odit ad officiis distinctio dignissimos rem voluptate ipsum hic eaque, facilis deleniti doloremque assumenda nisi nesciunt dolorem at velit consequuntur reiciendis!",
                R.drawable.poster_mortal_engines
            )
        )

        return movies

    }

    fun getAllTvShows(): List<MovieModel> {
        val series = ArrayList<MovieModel>()

        series.add(
            MovieModel(
                1,
                "series",
                "ARROW",
                "2012",
                "October 10, 2012",
                "42",
                "Crime, Drama, Mystery, Action & Adventure",
                "Greg Berlanti",
                "Paul Blackthorne, Emily Bett Rickards, David Ramsey, Stephen Amell",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                R.drawable.poster_arrow
            )
        )
        series.add(
            MovieModel(
                2,
                "series",
                "DOOM PATROL",
                "2019",
                "February 15, 2019",
                "49",
                "Sci Fi & Fantasy, Drama",
                "Jeremy Carver",
                "Diane Guerrero, April Bowlby, Joivan Wade, Riley Shanahan",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                R.drawable.poster_doom_patrol
            )
        )
        series.add(
            MovieModel(
                3,
                "series",
                "DRAGON BALL",
                "1986",
                "February 26, 1986",
                "25",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "",
                "Masako Nozawa, Mayumi Tanaka, Hiromi Tsuru, Toru Furuya",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                R.drawable.poster_dragon_ball
            )
        )
        series.add(
            MovieModel(
                4,
                "series",
                "FAIRYTAIL",
                "2009",
                "October 12, 2009",
                "25",
                "Action & Adventure, Animation, Comedy, Scf-Fi & Fantasy, Mystery",
                "",
                "Yoshimitsu Shinoyama, Eiji Miyashita, Fuyukana Ono, Daisuke Namikawa",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                R.drawable.poster_fairytail
            )
        )
        series.add(
            MovieModel(
                5,
                "series",
                "FAMILY GUY",
                "2010",
                "May 23, 2010",
                "55",
                "Animation, Comedy, Fantasy, Science Fiction",
                "Dominic Polcino, James Purdum, Peter Shin",
                "H. Jon Benjamin, James Wood, Seth MacFarlane, Alex Borstein",
                "Peter makes good on another power outage at home by retelling Star Wars Episode V: The Empire Strikes Back.",
                R.drawable.poster_family_guy
            )
        )
        series.add(
            MovieModel(
                6,
                "series",
                "FLASH",
                "2014",
                "October 7, 2014",
                "44",
                "Drama, Sci-Fi & fantasy",
                "Greg Berlanti",
                "Grant Gustin, Candice Patton, Danielle Panabaker, Jesse L. Martin",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                R.drawable.poster_flash
            )
        )
        series.add(
            MovieModel(
                7,
                "series",
                "GOT",
                "2011",
                "April 17, 2011",
                "60",
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
                "David Benioff",
                "Nikolaj Coster-Waldau, Lena Headey, Emilia Clarke, Kit Harington",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                R.drawable.poster_got
            )
        )
        series.add(
            MovieModel(
                8,
                "series",
                "GOTHAM",
                "2014",
                "September 22, 2014",
                "43",
                "Drama, Crime, Sci-Fi & Fantasy",
                "Bruno Heller",
                "Ben McKenzie, Donal Logue, David Mazouz, Sean Pertwee",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                R.drawable.poster_gotham
            )
        )
        series.add(
            MovieModel(
                9,
                "series",
                "GREY'S ANATOMY",
                "2005",
                "March 27, 2005",
                "43",
                "Drama",
                "Shonda Rhimes",
                "Ellen Pompeo, James Pickens Jr., Chandra Wilson, Justin Chambers",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                R.drawable.poster_grey_anatomy
            )
        )
        series.add(
            MovieModel(
                10,
                "series",
                "HANNA",
                "2019",
                "Marxh 28, 2019",
                "50",
                "Action 7 Adventure, Drama",
                "David Farr",
                "Exme Creed Miles, Mireille Enos, Dermot Mulroney, Joel Kinnaman",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                R.drawable.poster_hanna
            )
        )
        series.add(
            MovieModel(
                11,
                "series",
                "MARVEL'S IRON FIST",
                "2017",
                "March 17, 2017",
                "55",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Scott Buck",
                "Finn Jones, Jessica Henwick, Jessica Stroup, Tom Pelphrey, Sacha Dhawan",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                R.drawable.poster_iron_fist
            )
        )
        series.add(
            MovieModel(
                12,
                "series",
                "NARUTO SHIPUDDEN",
                "2007",
                "February 15, 2007",
                "25",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "",
                "Jouji Nakata, Junko Takeuchi, Chie Nakamura, Noriaki Sugiyama",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                R.drawable.poster_naruto_shipudden
            )
        )
        series.add(
            MovieModel(
                13,
                "series",
                "NCIS",
                "2003",
                "September 23, 2003",
                "45",
                "Crime, Action & Adventure, Drama",
                "Donald P. Bellisario, Don McGill",
                "Mark Harmon, David McCallum, Sean Murray, Pauley Perrette",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                R.drawable.poster_ncis
            )
        )

        return series
    }
}