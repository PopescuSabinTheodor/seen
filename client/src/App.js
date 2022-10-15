
import React from 'react';
import { Button, buttonClasses, radioClasses, TextField } from '@mui/material';
import { css } from '@emotion/react';
import { Radio } from '@mui/material';


const buttonStyles =`
background-color: #20b2aa;

:disabled {
  background-color: #FFF;
}
&.${buttonClasses.fullWidth} {
  background-color: #2e8b57;
}
:hover {
  background-color: #2e8b57;
}`


function App() {
  return (
    <div className="App">
      <Button
        sx={css`${buttonStyles}`}
        variant="text"
        fullWidth
        text="warning"
        >Hello World</Button>;
      <TextField>Mda</TextField>
      <Radio sx={css`&.${radioClasses.checked} { color: red }`}/>
    </div>
  );
}

export default App;
