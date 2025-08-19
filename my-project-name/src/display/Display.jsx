import React from 'react';
import AboutMe from '../components/AboutMe.jsx';
import Skills from '../components/Skills.jsx';
import Projects from '../components/Projects.jsx';
import Contact from '../components/Contact.jsx';

function Display() {
  return (
    <div>
      <AboutMe />
      <Skills />
      <Projects />
      <Contact />
    </div>
  );
}

export default Display;
