import React from 'react';
import { Card } from '../common/Card';
import LineChart from '../charts/LineChart';
import { Button } from '../common/Button';
import { Search } from '../common/Search';

export const Main: React.FC = () => {

  const buttonStyle = "max-w-25 grow-1 bg-blue-600 text-black font-semibold hover:bg-blue-700 hover:text-white";

  return (
      <>
      <section className="mb-8 flex space-x-5 ">
        <Button 
          className={buttonStyle}
          value="1DAY"
        />
        <Button 
          className={buttonStyle}
          value="1WEEK"
        />
        <Button 
          className={buttonStyle}
          value="1MONTH"
        />

        <Search data="" className="grow-5 text-black"/>        
        
      </section>

      <section className="grid grid-cols-2 md:grid-cols-4 gap-6 mb-8">
        <Card
          title="CURRENT PRICE"
          image="https://placehold.co/400x250"
        />
        <Card
          title="24H CHANGE"
          image="https://placehold.co/400x250"
        />
        <Card
          title="24H VOLUME"
          image="https://placehold.co/400x250"
        />
        <Card
          title="MARKET CAP"
          image="https://placehold.co/400x250"
        />


      </section>
      <section>
        <LineChart className=""/>
      </section>
    </>
  );
};