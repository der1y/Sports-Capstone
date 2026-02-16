import AuthService from "../../services/AuthService";
import {useState} from 'react';
import TeamComponent from "../../components/TeamComponent/TeamComponent";

export default function NFLView() {
    // create a variable called standings and set it to null
    // setStandings is how we can update the content
    const[standings, setStandings] = useState(null);

    function getTeams() {
        AuthService.getStandings() // async communication
        .then((response) => {
            // console.log(response);
            setStandings(response.data);
        })
    }

    return (
        <>
            <h1>NFL Standings</h1>
            <button onClick={getTeams}>Get Teams</button>
            { standings && (
                <TeamComponent teams={standings}/>
            )}
        </>
    )
}