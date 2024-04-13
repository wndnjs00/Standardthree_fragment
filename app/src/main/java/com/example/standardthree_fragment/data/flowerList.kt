package com.example.standardthree_fragment.data

fun flowerList() : ArrayList<Flower> {
    return arrayListOf(
        Flower(
            id = 1,
            name = "데이지",
            description = "봄부터 가을까지 피며\n흰색, 연한 홍색\n또는 홍자색입니다"
        ),
        Flower(
            id = 2,
            name = "리시안셔스",
            description = "'변치 않는 사랑'이라는\n꽃말을 가지고있습니다"
        ),
        Flower(
            id = 3,
            name = "장미",
            description = "장미는 6~7월에 피는데,\n줄기 끝에 한개 또는\n여러개가 핍니다"
        )
    )
}