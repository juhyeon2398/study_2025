import React from 'react';
import styled from 'styled-components';

const Section = styled.section`
  background: #f7f7fa;
  padding: 2rem;
  border-radius: 16px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.07);
  margin: 2rem 0;
`;

const Title = styled.h2`
  color: #4a90e2;
  font-size: 2rem;
  margin-bottom: 1rem;
`;

const SkillList = styled.ul`
  list-style: none;
  padding: 0;
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
`;

const SkillItem = styled.li`
  background: #fff;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  padding: 0.75rem 1.5rem;
  font-size: 1.1rem;
  color: #333;
  box-shadow: 0 1px 4px rgba(0,0,0,0.04);
`;

function Skills() {
  return (
    <Section>
      <Title>Skills</Title>
      <SkillList>
        <SkillItem>JavaScript (ES6+)</SkillItem>
        <SkillItem>React</SkillItem>
        <SkillItem>HTML5 & CSS3</SkillItem>
        <SkillItem>Git & GitHub</SkillItem>
        <SkillItem>Redux</SkillItem>
      </SkillList>
    </Section>
  );
}

export default Skills;
