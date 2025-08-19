import React from 'react';
import styled from 'styled-components';

const Section = styled.section`
  background: #fffbe6;
  padding: 2rem;
  border-radius: 16px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.07);
  margin: 2rem 0;
`;

const Title = styled.h2`
  color: #f9a826;
  font-size: 2rem;
  margin-bottom: 1rem;
`;

const ProjectList = styled.ul`
  list-style: none;
  padding: 0;
`;

const ProjectItem = styled.li`
  background: #fff;
  border: 1px solid #ffe0a3;
  border-radius: 8px;
  padding: 1rem 1.5rem;
  margin-bottom: 1rem;
  box-shadow: 0 1px 4px rgba(0,0,0,0.04);
`;

const ProjectTitle = styled.strong`
  color: #f9a826;
  font-size: 1.15rem;
`;

function Projects() {
  return (
    <Section>
      <Title>Projects</Title>
      <ProjectList>
        <ProjectItem>
          <ProjectTitle>포트폴리오 웹사이트</ProjectTitle> - React로 제작한 개인 포트폴리오 사이트
        </ProjectItem>
        <ProjectItem>
          <ProjectTitle>Todo App</ProjectTitle> - 할 일 관리 앱, CRUD 기능 구현
        </ProjectItem>
        <ProjectItem>
          <ProjectTitle>Weather App</ProjectTitle> - OpenWeather API를 활용한 날씨 정보 제공
        </ProjectItem>
      </ProjectList>
    </Section>
  );
}

export default Projects;
