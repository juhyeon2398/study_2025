import React from 'react';
import styled from 'styled-components';

const Section = styled.section`
  background: #eaf6ff;
  padding: 2rem;
  border-radius: 16px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.07);
  margin: 2rem 0;
`;

const Title = styled.h2`
  color: #0077b6;
  font-size: 2rem;
  margin-bottom: 1rem;
`;

const Text = styled.p`
  color: #333;
  font-size: 1.15rem;
  line-height: 1.7;
`;

function AboutMe() {
  return (
    <Section>
      <Title>About Me</Title>
      <Text>안녕하세요! 프론트엔드 개발자입니다. React, JavaScript, CSS에 관심이 많고, 사용자 경험을 중요하게 생각합니다.</Text>
    </Section>
  );
}

export default AboutMe;
