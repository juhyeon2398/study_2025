import React from 'react';
import styled from 'styled-components';

const Section = styled.section`
  background: #f0fff0;
  padding: 2rem;
  border-radius: 16px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.07);
  margin: 2rem 0;
`;

const Title = styled.h2`
  color: #43a047;
  font-size: 2rem;
  margin-bottom: 1rem;
`;

const Info = styled.p`
  color: #333;
  font-size: 1.1rem;
  margin-bottom: 0.5rem;
`;

const Link = styled.a`
  color: #43a047;
  text-decoration: none;
  font-weight: bold;
  &:hover {
    text-decoration: underline;
  }
`;

function Contact() {
  return (
    <Section>
      <Title>Contact</Title>
      <Info>Email: your.email@example.com</Info>
      <Info>
        GitHub: <Link href="https://github.com/your-github" target="_blank" rel="noopener noreferrer">your-github</Link>
      </Info>
    </Section>
  );
}

export default Contact;
