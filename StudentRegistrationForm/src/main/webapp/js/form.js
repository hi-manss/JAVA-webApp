// ***********************************************
// SELECTORS-------------------------------------
// ***********************************************
const header = document.querySelector(".header");
const navAbout = document.querySelectorAll(".nav-about");
const navRegis = document.querySelectorAll(".nav-regis");
const navNotes = document.querySelectorAll(".nav-notes");
const navResult = document.querySelectorAll(".nav-result");
const regisForm = document.querySelector(".regis-form");
const aboutForm = document.querySelector(".regis-about");
const notesForm = document.querySelector(".regis-notes");
const resultForm = document.querySelector(".regis-result");
const notesSelect = document.querySelector(".sem");
const sem1 = document.querySelector(".sem-1");
const sem2 = document.querySelector(".sem-2");
const sem3 = document.querySelector(".sem-3");
const btnNavEl = document.querySelector(".btn-mobile-nav");
const headerEl = document.querySelector(".regis-nav");

// ***********************************************
// Navigation-------------------------------------
// ***********************************************
const mobileNav = () => {
  headerEl.classList.toggle("nav-open");
};

const aboutNav = () => {
  aboutForm.classList.remove("hidden");
  regisForm.classList.add("hidden");
  notesForm.classList.add("hidden");
  resultForm.classList.add("hidden");
};

const regisNav = () => {
  regisForm.classList.remove("hidden");
  aboutForm.classList.add("hidden");
  notesForm.classList.add("hidden");
  resultForm.classList.add("hidden");
};

const notesNav = () => {
  notesForm.classList.remove("hidden");
  regisForm.classList.add("hidden");
  aboutForm.classList.add("hidden");
  resultForm.classList.add("hidden");
};

const resultNav = () => {
  resultForm.classList.remove("hidden");
  aboutForm.classList.add("hidden");
  regisForm.classList.add("hidden");
  notesForm.classList.add("hidden");
};

navAbout.forEach((nav) => nav.addEventListener("click", aboutNav));
navRegis.forEach((nav) => nav.addEventListener("click", regisNav));
navNotes.forEach((nav) => nav.addEventListener("click", notesNav));
navResult.forEach((nav) => nav.addEventListener("click", resultNav));

//Mobile Nav
btnNavEl.addEventListener("click", mobileNav);

// ***********************************************
// Notes------------------------------------------
// ***********************************************
const notesSem0 = () => {
  sem1.classList.add("hidden");
  sem2.classList.add("hidden");
  sem3.classList.add("hidden");
};
const notesSem1 = () => {
  sem1.classList.remove("hidden");
  sem3.classList.add("hidden");
  sem2.classList.add("hidden");
};
const notesSem2 = () => {
  sem2.classList.remove("hidden");
  sem1.classList.add("hidden");
  sem3.classList.add("hidden");
};
const notesSem3 = () => {
  sem3.classList.remove("hidden");
  sem1.classList.add("hidden");
  sem2.classList.add("hidden");
};

const notesOption = () => {
  if (notesSelect.value === "sem-1") {
    notesSem1();
  } else if (notesSelect.value === "sem-2") {
    notesSem2();
  } else if (notesSelect.value === "sem-3") {
    notesSem3();
  } else {
    notesSem0();
  }
};

notesSelect.addEventListener("change", notesOption);

// ***************************************
// Smooth scrolling animation
//*************************************** */

const allLinks = document.querySelectorAll("a:link");

allLinks.forEach(function (link) {
  link.addEventListener("click", function (e) {
    const href = link.getAttribute("href");

    // Scroll back to top
    if (href === "#") {
      e.preventDefault();
      window.scrollTo({
        top: 0,
        behavior: "smooth",
      });
    }

    // Close mobile naviagtion
    if (link.classList.contains("nav-link"))
      headerEl.classList.toggle("nav-open");
  });
});

//*************************** */
// Sticky navigation
// **************************
const obs = new IntersectionObserver(
  function (entries) {
    const ent = entries[0];

    if (ent.isIntersecting === false) {
      document.body.classList.add("sticky");
    }

    if (ent.isIntersecting === true) {
      document.body.classList.remove("sticky");
    }
  },
  {
    // In the viewport
    root: null,
    threshold: 0,
    rootMargin: "-80px",
  }
);
obs.observe(header);
