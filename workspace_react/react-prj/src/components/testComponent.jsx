import React from 'react';

const TestComponent = (props) => {
    console.log(" testComponent  :  props", props)
    return (
        <div id="div" name="div" style={{"color": "red"}}>
            안녕하세요. {props.name}
        </div>
    );
};

export default TestComponent;