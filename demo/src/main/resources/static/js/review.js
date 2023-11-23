const reviewWrap = document.getElementById("reviewWrap");
const leftArrow = document.querySelector(".left-arrow-wrap .arrow");
const rightArrow = document.querySelector(".right-arrow-wrap .arrow");
const imgBox = document.getElementById("imgBox");
const name = document.getElementById("name");
const profession = document.getElementById("profession");
const words = document.getElementById("words");

let people = [{
    photo: "url('./image/1.jpg')",
    name: "Natalie Grey",
    profession: "Software Engineer",
    words: "While the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among the tall grass by the trickling stream; and, as I lie close to the earth, a thousand unknown plants are noticed by me:"
},
    {
        // photo: "url('https://cdn.pixabay.com/photo/2018/06/27/07/45/college-student-3500990_960_720.jpg')",
        photo:"url('./image/tom.jpg')",
        name: "邹嘉豪",
        profession: "Student",
        words: "I'm baby woke mlkshk wolf bitters live-edge blue bottle, hammock freegan copper mug whatever cold-pressed. Bitters hashtag tumeric sriracha hot chicken gentrify portland. Dreamcatcher neutra irony."
    },
    {
        // photo: "url('https://cdn.pixabay.com/photo/2015/01/08/18/30/man-593372__340.jpg')",
        photo: "url('./image/spiderman.jpg')",
        name: "Branson Cook",
        profession: "Web Developer",
        words: "Hello, I'm a web developer. I have been working as a web developer for 5 years. I have worked in many companies and I have worked as a freelancer. I have worked in a team and I have worked alone. I have worked in a big company and I have worked in a small one."
    },
    {
        // photo: "url('https://cdn.pixabay.com/photo/2012/10/26/02/12/actor-63082_960_720.jpg')",
        photo: "url('./image/hacker.jpg')",
        name: "Julius Grohn",
        profession: "Designer",
        words: "Working as a designer is a very interesting job. You can work in a team or alone, you can work in a company or as a freelancer. You can work in an office or at home. You can work in a big company or in a small one. You can work in a big city or in a small town."
    }
];

// set the first person
imgBox.style.backgroundImage = people[0].photo;
name.innerText = people[0].name;
profession.innerText = people[0].profession;
words.innerText = people[0].words;
let currentPerson = 0;

//Select the side where you want to slide
function slide(side, personNumber) {
    let reviewWrapWidth = reviewWrap.offsetWidth + "px";
    let wordsHeight = words.offsetHeight + "px";
    //(+ or -)
    let side1symbol = side === "left" ? "" : "-";
    let side2symbol = side === "left" ? "-" : "";

    setTimeout(() => {
        imgBox.style.backgroundImage = people[personNumber].photo;
    }, 0);
    setTimeout(() => {
        words.style.height = wordsHeight;
    }, 100);
    setTimeout(() => {
        name.innerText = people[personNumber].name;
    }, 200);
    setTimeout(() => {
        profession.innerText = people[personNumber].profession;
    }, 300);
    setTimeout(() => {
        words.innerText = people[personNumber].words;
    }, 400);
}

function setNextCardLeft() {
    if (currentPerson === 3) {
        currentPerson = 0;
        slide("left", currentPerson);
    } else {
        currentPerson++;
    }

    slide("left", currentPerson);
}

function setNextCardRight() {
    if (currentPerson === 0) {
        currentPerson = 3;
        slide("right", currentPerson);
    } else {
        currentPerson--;
    }

    slide("right", currentPerson);
}
leftArrow.addEventListener("click", setNextCardLeft);
rightArrow.addEventListener("click", setNextCardRight);