package com.example.standardthree_fragment.data

fun flowerList() : ArrayList<Flower> {
    return arrayListOf(
        Flower(
            id = 1,
            name = "데이지",
            description = "봄부터 가을까지 피며 흰색, 연한 홍색, 홍색 또는 홍자색입니다"
        ),
        Flower(
            id = 2,
            name = "리시안셔스",
            description = "변치 않는 사랑'이라는 꽃말답게 부케나 연인에게 선물하는 꽃다발에 자주 사용되고 분홍색의 하늘거리는 여리여리한 꽃잎이 여러송이 달려있어 너무 사랑스러운 꽃입니다"
        ),
        Flower(
            id = 3,
            name = "해바라기",
            description = "장미꽃은 6~7월에 피는데, 줄기 끝에 한 개 내지 여러 개가 피고 향기가 난다. 꽃은 5장의 꽃받침,여러 장의 알모양 꽃잎과 수술, 한 개의 암술로 되어 있다"
        ),
    )
}