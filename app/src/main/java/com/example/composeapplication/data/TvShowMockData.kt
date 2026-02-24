package com.example.composeapplication.data

import com.example.composeapplication.modal.TvShowlist

object TvShowMockData {
    val tvShows = listOf(
        TvShowlist(
            id = 1,
            name = "Breaking Bad",
            year = 2008,
            rating = 9.5,
            imageUrl = "https://picsum.photos/seed/breakingbad/200/300",
            description = "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future."
        ),
        TvShowlist(
            id = 2,
            name = "Game of Thrones",
            year = 2011,
            rating = 9.2,
            imageUrl = "https://picsum.photos/seed/got/200/300",
            description = "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia."
        ),
        TvShowlist(
            id = 3,
            name = "Stranger Things",
            year = 2016,
            rating = 8.7,
            imageUrl = "https://picsum.photos/seed/strangerthings/200/300",
            description = "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back."
        ),
        TvShowlist(
            id = 4,
            name = "The Crown",
            year = 2016,
            rating = 8.6,
            imageUrl = "https://picsum.photos/seed/thecrown/200/300",
            description = "Follows the political rivalries and romance of Queen Elizabeth II's reign and the events that shaped the second half of the twentieth century."
        ),
        TvShowlist(
            id = 5,
            name = "The Mandalorian",
            year = 2019,
            rating = 8.7,
            imageUrl = "https://picsum.photos/seed/mandalorian/200/300",
            description = "The travels of a lone bounty hunter in the outer reaches of the galaxy, far from the authority of the New Republic."
        ),
        TvShowlist(
            id = 6,
            name = "The Boys",
            year = 2019,
            rating = 8.7,
            imageUrl = "https://picsum.photos/seed/theboys/200/300",
            description = "A group of vigilantes set out to take down corrupt superheroes who abuse their superpowers."
        ),
        TvShowlist(
            id = 7,
            name = "Dark",
            year = 2017,
            rating = 8.7,
            imageUrl = "https://picsum.photos/seed/dark/200/300",
            description = "A family saga with a supernatural twist, set in a German town where the disappearance of two young children exposes the relationships among four families."
        ),
        TvShowlist(
            id = 8,
            name = "Friends",
            year = 1994,
            rating = 8.9,
            imageUrl = "https://picsum.photos/seed/friends/200/300",
            description = "Follows the personal and professional lives of six twenty to thirty-something-year-old friends living in Manhattan."
        )
    )
}
