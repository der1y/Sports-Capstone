import styles from './TeamComponent.module.css';
import { Link } from 'react-router-dom';

export default function TeamComponent({ teams }) {

    return (
        <div className={styles.teamGrid}>
            {teams.map((teamItem, index) => (
                <div key={index} className={styles.teamItem}>
                    <Link
                        to={`/nfl/${teamItem.Team}`}>
                        {teamItem.Name}
                    </Link>
                </div>
            ))}
        </div>
    )
}